package com.kamath.bookdigest.ui.screens
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.kamath.bookdigest.viewModels.HomeScreenViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kamath.bookdigest.data.model.BookNeo
import com.kamath.bookdigest.data.model.Genre
import com.kamath.bookdigest.ui.screens.common.BookCard
import com.kamath.bookdigest.ui.screens.common.GenreCard


@Composable
fun HomeScreen(){
    val TAG = "HomeScreen"
    val viewModel:HomeScreenViewModel = hiltViewModel()
    val booksLiveData = viewModel._getBooksLiveData
    val genresLiveData = viewModel._getGenresLiveData

    val books = remember { mutableStateOf(emptyList<BookNeo>()) }
    val genres = remember { mutableStateOf(emptyList<Genre>()) }

    LaunchedEffect(booksLiveData){
        viewModel.getAllBooks()
    }
    LaunchedEffect(genresLiveData) {
        viewModel.getGenres()
    }
    booksLiveData.observeAsState().value?.let {
        books.value = it.filterNotNull()
    }
    genresLiveData.observeAsState().value?.let {
        genres.value = it
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        .padding(16.dp)) {
        Text(
            text = "Genres",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            content = {
                items(genres.value.size) { it ->
                    GenreCard(
                        genre = genres.value[it].name,
                    )
                }
            }
        )
        Text(
            text = "Books",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        LazyColumn {
            items(books.value.size) {
                BookCard(book = books.value[it])
            }
        }
    }
}