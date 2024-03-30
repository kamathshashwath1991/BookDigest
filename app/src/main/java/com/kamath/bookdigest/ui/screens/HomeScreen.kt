package com.kamath.bookdigest.ui.screens
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.kamath.bookdigest.viewModels.HomeScreenViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.kamath.bookdigest.data.model.BookNeo


@Composable
fun HomeScreen(){
    val TAG = "HomeScreen"
    val viewModel:HomeScreenViewModel = hiltViewModel()
    val homeScreenLiveData = viewModel._getHomeScreenLiveData
    val books = remember { mutableStateOf(emptyList<BookNeo>()) }

    LaunchedEffect(true){
        viewModel.getAllBooks()
    }
    homeScreenLiveData.observeAsState().value?.let {
        books.value = it.filterNotNull()
    }
    Text(text = books.value.toString())
}