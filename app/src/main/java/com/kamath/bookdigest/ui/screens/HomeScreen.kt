package com.kamath.bookdigest.ui.screens
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.hilt.navigation.compose.hiltViewModel
import com.kamath.bookdigest.viewModels.HomeScreenViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    //Text(text = books.value.toString())
    BookList(books = books.value)
}

@Composable
fun BookList(books: List<BookNeo>){
    LazyColumn(modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ){
        items(books) { book ->

        }
    }
}

@Composable
fun BookItem(book: BookNeo) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = book.title, style = MaterialTheme.typography.titleMedium)
            Text(text = "Author: ${book.author}")
            Text(text = "Genre: ${book.genre}")
            Text(text = "Pages: ${book.pages}")
            Text(text = "Year: ${book.year}")
            Text(text = "Original Cost: $${book.originalCost}")
            Text(text = "ISBN: ${book.isbn}")
            Text(text = "Published Date: ${book.publishedDate}")
        }
    }
}
