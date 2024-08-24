package com.kamath.bookdigest.viewModels

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavControllerViewModel @Inject constructor(
    val navControllerHolder: NavControllerHolder
) : ViewModel()