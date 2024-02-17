package com.kamath.bookdigest.utility

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kamath.bookdigest.viewModels.BooksViewModel
import kotlinx.coroutines.launch
import kotlin.math.log

@Composable
fun ScanBarcode(
    onScanBarcode: suspend () -> Unit,
    barcodeValue: String?
) {
    val TAG = "SCAN_BARCODE"
    val scope = rememberCoroutineScope()
    val booksViewModel: BooksViewModel = hiltViewModel()
    // Observe bookDetailsLiveData
    val bookDetails = booksViewModel.bookDetailLiveData.observeAsState()
    val bookName = bookDetails.value?.book?.title

    if (barcodeValue != null) {
        // Call searchBookByIsbn when barcodeValue is not null
        LaunchedEffect(barcodeValue) {
            booksViewModel.searchBookByIsbn(barcodeValue)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

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
                //style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = bookName ?: "",
            style = MaterialTheme.typography.displayMedium
        )

    }
}