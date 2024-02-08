package com.kamath.bookdigest.appEntry

import androidx.compose.runtime.Composable

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