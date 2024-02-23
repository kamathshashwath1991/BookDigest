package com.kamath.bookdigest.ui.screens.common

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter

@Composable
fun CoilImage(url: String) {
    val painter = rememberImagePainter(url)
    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}