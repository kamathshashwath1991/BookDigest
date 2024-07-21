package com.kamath.bookdigest

sealed class Routes(val route:String) {
    object MainScreen: Routes("main")
}

