package com.kamath.bookdigest.ui.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.kamath.bookdigest.viewModels.HomeScreenViewModel

@Composable
fun HomeScreen(){
    val TAG = "HomeScreen"
    val viewModel:HomeScreenViewModel = hiltViewModel()
    val homeScreenLiveData = viewModel._getHomeScreenLiveData

    LaunchedEffect(homeScreenLiveData){
        viewModel.getAllBooks()
    }
}