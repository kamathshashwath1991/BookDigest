package com.kamath.bookdigest

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kamath.bookdigest.screens.LoginScreen
import com.kamath.bookdigest.screens.SignUpScreen
import com.kamath.bookdigest.ui.theme.BookDigestTheme

@Composable
fun MyApp(){


    BookDigestTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.SignUpScreen.route){
                composable(Routes.SignUpScreen.route) {
                    SignUpScreen(navController)
                }
                composable(Routes.LoginScreen.route) {
                    LoginScreen(navController)
                }
            }
        }
    }
}