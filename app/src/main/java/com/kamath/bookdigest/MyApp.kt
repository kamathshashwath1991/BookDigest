package com.kamath.bookdigest

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kamath.bookdigest.screens.HomeScreen
import com.kamath.bookdigest.screens.LoginScreen
import com.kamath.bookdigest.screens.SignUpScreen
import com.kamath.bookdigest.screens.UserDetailScreen
import com.kamath.bookdigest.ui.theme.BookDigestTheme
import com.kamath.bookdigest.viewModels.UserViewModel

@Composable
fun MyApp(){
   val userViewModel:UserViewModel = hiltViewModel()

    BookDigestTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.HomeScreen.route){
                composable(Routes.SignUpScreen.route) {
                    SignUpScreen(navController)
                }
                composable(Routes.LoginScreen.route) {
                    LoginScreen(navController)
                }
                composable(Routes.HomeScreen.route){
                    HomeScreen()
                }
//                composable("userDetail/{userId}",
//                    arguments = listOf(navArgument("userId"){type = NavType.StringType})
//                    ) {backStackEntry: NavBackStackEntry ->
//                    val userId = backStackEntry.arguments?.getString("userId")
//                    UserDetailScreen(userId)
//
//                }
            }
        }
    }
}