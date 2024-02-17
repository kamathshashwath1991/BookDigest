package com.kamath.bookdigest.ui.screens.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kamath.bookdigest.data.model.Book

@Composable
fun BookDetails(book:Book){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BookDetailItem(label = "Book Title", value = book.title ?: "No Title")
        BookDetailItem(label = "Author", value = book.authors?.joinToString(", ") ?: "Unknown")
        BookDetailItem(label = "Publisher", value = book.publisher ?: "Unknown")
        // Add more book details as needed
    }
}
@Composable
fun BookDetailItem(label: String, value: String) {
    Text(
        text = "$label: $value",
        modifier = Modifier.padding(vertical = 4.dp)
    )
}