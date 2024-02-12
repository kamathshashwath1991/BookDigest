package com.kamath.bookdigest

sealed class Routes(val route:String) {
    object SignUpScreen: Routes("signUp")
    object LoginScreen: Routes("login")
    object MainScreen: Routes("main")
    object UserDetailScreen: Routes("userDetail")
    object SignInScreen: Routes("sign_in")
}

