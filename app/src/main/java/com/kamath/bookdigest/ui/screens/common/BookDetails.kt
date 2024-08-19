package com.kamath.bookdigest.ui.screens.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kamath.bookdigest.data.model.BookDetailsResponse

@Composable
fun BookDetails(book: BookDetailsResponse){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(text = "Is this the book you scanned?")
            Spacer(modifier = Modifier.height(8.dp))
            CoilImage(url = book.book.image!!)
//            Card(
//                modifier = Modifier.fillMaxWidth(),
//                elevation = CardDefaults.cardElevation()
//            ) {
//                Row(modifier = Modifier.fillMaxWidth()) {
//                    // Book image on the left side
//                    Box(
//                        modifier = Modifier
//                            .weight(1f)
//                            .aspectRatio(1f)
//                    ) {
//                        // You can replace this with your actual book image loading logic
//                        CoilImage(url = book.image!!)
//                    }
//
//                    // Book details on the right side in a column
//                    Column(
//                        modifier = Modifier
//                            .weight(1f)
//                            .padding(8.dp)
//                    ) {
//
//                    }
//                }
//            }
        }
    }
}

