package com.kamath.bookdigest.appEntry

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kamath.bookdigest.ui.screens.HomeScreen
import com.kamath.bookdigest.ui.screens.LoginScreen
import com.kamath.bookdigest.ui.screens.SignUpScreen
import com.kamath.bookdigest.ui.screens.UserDetailScreen
import com.kamath.bookdigest.ui.theme.BookDigestTheme
import com.kamath.bookdigest.viewModels.UserViewModel

@Composable
fun MyApp(){

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
                    HomeScreen(navController)
                }
                composable("userDetail/{userId}") { backStackEntry ->
                    val userId = backStackEntry.arguments?.getString("userId")
                    UserDetailScreen(userId.toString())
                }
            }
        }
    }
}