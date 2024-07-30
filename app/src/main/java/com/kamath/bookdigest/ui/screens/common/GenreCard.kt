package com.kamath.bookdigest.ui.screens.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GenreCard(genre: String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp),
           // .clickable { onGenreSelected(genre) },
        elevation = CardDefaults.cardElevation(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ){
            Text(
                text = genre,
                style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}