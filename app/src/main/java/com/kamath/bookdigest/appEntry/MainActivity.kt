package com.kamath.bookdigest.appEntry

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.identity.Identity
import com.kamath.bookdigest.ui.screens.HomeScreen
import com.kamath.bookdigest.ui.screens.LoginScreen
import com.kamath.bookdigest.ui.screens.SignInScreen
import com.kamath.bookdigest.ui.screens.SignUpScreen
import com.kamath.bookdigest.ui.screens.UserDetailScreen
import com.kamath.bookdigest.ui.theme.BookDigestTheme
import com.kamath.bookdigest.utility.GoogleSignInClient
import com.kamath.bookdigest.viewModels.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val googleSignInClient by lazy {
        GoogleSignInClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookDigestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val scaffoldState = rememberBottomSheetScaffoldState()
                    NavHost(navController = navController, startDestination = Routes.HomeScreen.route){
                        composable(Routes.SignInScreen.route){
                            val viewModel = viewModel<SignInViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()

                            LaunchedEffect(key1 = Unit) {
                                if(googleSignInClient.getSignedInUser() != null) {
                                    navController.navigate(Routes.HomeScreen.route)
                                }
                            }

                            val launcher = rememberLauncherForActivityResult(
                                contract = ActivityResultContracts.StartIntentSenderForResult(),
                                onResult = { result ->
                                    if(result.resultCode == RESULT_OK) {
                                        lifecycleScope.launch {
                                            val signInResult = googleSignInClient.signInWithIntent(
                                                intent = result.data ?: return@launch
                                            )
                                            viewModel.onSignInResult(signInResult)
                                        }
                                    }
                                }
                            )

                            LaunchedEffect(key1 = state.isSignInSuccessful) {
                                if(state.isSignInSuccessful) {
                                    Toast.makeText(
                                        applicationContext,
                                        "Sign in successful",
                                        Toast.LENGTH_LONG
                                    ).show()

                                    navController.navigate(Routes.HomeScreen.route)
                                    viewModel.resetState()
                                }
                            }
                            
                            SignInScreen(
                                state = state,
                                onSignInClick = {
                                    lifecycleScope.launch {
                                        val signInIntentSender = googleSignInClient.signIN()
                                        launcher.launch(
                                            IntentSenderRequest.Builder(
                                                signInIntentSender?:return@launch
                                            ).build()
                                        )
                                        Log.d("Inside Sign In", "onCreate: clicked")
                                    }
                                }
                            )
                        }
                        composable(Routes.HomeScreen.route){
                            HomeScreen(navController)
                        }
                    }
                }
            }
        }
    }


}
