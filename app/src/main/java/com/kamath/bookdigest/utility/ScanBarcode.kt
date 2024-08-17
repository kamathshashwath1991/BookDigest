package com.kamath.bookdigest.utility
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.kamath.bookdigest.ui.screens.common.BookDetails
import com.kamath.bookdigest.viewModels.BooksViewModel
import kotlinx.coroutines.launch

@Composable
fun ScanBarcode(
    onScanBarcode: suspend () -> Unit,
    barcodeValue: String?
) {
    val scope = rememberCoroutineScope()
    val booksViewModel: BooksViewModel = hiltViewModel()
    // Observe bookDetailsLiveData
    val bookDetails = booksViewModel.bookDetailLiveData.observeAsState()
    val book = bookDetails.value?.book
    val showButton = book?.title.isNullOrEmpty()

    if (barcodeValue != null) {
        LaunchedEffect(barcodeValue) {
            Log.d("TEST", "ScanBarcode: ")
            booksViewModel.searchBookByIsbn(barcodeValue)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (showButton){
            Button(
                modifier = Modifier
                    .fillMaxWidth(.85f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                onClick = {
                    scope.launch {
                        onScanBarcode()
                    }
                }) {
                Text(
                    text = "Scan Barcode",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.displayMedium,
                )
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth(.85f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                onClick = {
                    scope.launch {
                        //booksViewModel.createBook()
                    }
                }) {
                Text(
                    text = "Post",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.displayMedium,
                )
            }
        }else{
            BookDetails(book = book!!)
        }
    }
}