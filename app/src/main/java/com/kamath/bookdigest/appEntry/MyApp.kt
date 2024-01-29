package com.kamath.bookdigest.appEntry

import android.app.Activity.RESULT_OK
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kamath.bookdigest.ui.screens.HomeScreen
import com.kamath.bookdigest.ui.screens.LoginScreen
import com.kamath.bookdigest.ui.screens.SignUpScreen
import com.kamath.bookdigest.ui.screens.UserDetailScreen
import com.kamath.bookdigest.ui.theme.BookDigestTheme
import com.kamath.bookdigest.viewModels.SignInViewModel
import androidx.lifecycle.lifecycleScope

@Composable
fun MyApp(){

//    BookDigestTheme {
//        // A surface container using the 'background' color from the theme
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            val navController = rememberNavController()
//            NavHost(navController = navController, startDestination = Routes.SignInScreen.route){
//                composable(Routes.SignInScreen.route){
//                    val viewModel = viewModel<SignInViewModel>()
//                    val state by viewModel.state.collectAsStateWithLifecycle()
//
//                    val launcher = rememberLauncherForActivityResult(
//                        contract = ActivityResultContracts.StartIntentSenderForResult(),
//                        onResult = { result ->
//                            if(result.resultCode == RESULT_OK) {
//                                lifecycleScope.launch {
//                                    val signInResult = googleAuthUiClient.signInWithIntent(
//                                        intent = result.data ?: return@launch
//                                    )
//                                    viewModel.onSignInResult(signInResult)
//                                }
//                            }
//                        }
//                    )
//
//                }
//                composable(Routes.SignUpScreen.route) {
//                    SignUpScreen(navController)
//                }
//                composable(Routes.LoginScreen.route) {
//                    LoginScreen(navController)
//                }
//                composable(Routes.HomeScreen.route){
//                    HomeScreen(navController)
//                }
//                composable("userDetail/{userId}") { backStackEntry ->
//                    val userId = backStackEntry.arguments?.getString("userId")
//                    UserDetailScreen(userId.toString())
//                }
//            }
//        }
//    }
}