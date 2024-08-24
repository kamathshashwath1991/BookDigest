package com.kamath.bookdigest.viewModels

import androidx.navigation.NavHostController
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavControllerHolder @Inject constructor() {
    lateinit var navController: NavHostController
        private set

    fun setNavController(navController: NavHostController) {
        this.navController = navController
    }
}