package com.kamath.bookdigest.ui.screens
import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
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
    val booksLiveData = viewModel._getBooksLiveData
    val genresLiveData = viewModel._getGenresLiveData

    val books = remember { mutableStateOf(emptyList<BookNeo>()) }
    val genres = remember { mutableStateOf(emptyList<String>()) }

    LaunchedEffect(booksLiveData,genresLiveData){
        viewModel.getAllBooks()
        viewModel.getGenres()
    }
    booksLiveData.observeAsState().value?.let {
        books.value = it.filterNotNull()
    }
    genresLiveData.observeAsState().value?.let {
        genres.value = it
    }
    LazyRow {
        items(genres.value.size) {
            Log.d(TAG, "HomeScreen: ${genres.value[it]}")
            Text(text = genres.value[it])
        }
    }
//    LazyColumn {
//        items(books.value.size) {
//            BookCard(book = books.value[it])
//        }
//    }
}