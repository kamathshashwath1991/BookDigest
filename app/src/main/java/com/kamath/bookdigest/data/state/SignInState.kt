package com.kamath.bookdigest.data.state

data class SignInState(
    val isSignInSuccessful:Boolean = false,
    val signInError:String? = null
)
