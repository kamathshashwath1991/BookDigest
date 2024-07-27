package com.kamath.bookdigest.ui.screens
import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.kamath.bookdigest.viewModels.HomeScreenViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.kamath.bookdigest.data.model.BookNeo
import com.kamath.bookdigest.ui.screens.common.BookCard


@Composable
fun HomeScreen(){
    val TAG = "HomeScreen"
    val viewModel:HomeScreenViewModel = hiltViewModel()
    val homeScreenLiveData = viewModel._getHomeScreenLiveData
    val books = remember { mutableStateOf(emptyList<BookNeo>()) }

    LaunchedEffect(homeScreenLiveData){
        viewModel.getAllBooks()
    }
    homeScreenLiveData.observeAsState().value?.let {
        books.value = it.filterNotNull()
        Log.d(TAG, "HomeScreen: ${books.value}")
    }
    LazyColumn {
        items(books.value.size) {
            BookCard(book = books.value[it])
        }
    }
}