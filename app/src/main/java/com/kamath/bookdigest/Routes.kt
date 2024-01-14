package com.kamath.bookdigest

sealed class Routes(val route:String) {
    object SignUpScreen:Routes("signUp")
    object LoginScreen:Routes("login")
}

