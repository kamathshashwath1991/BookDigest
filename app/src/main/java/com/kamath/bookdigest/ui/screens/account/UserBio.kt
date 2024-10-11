package com.kamath.bookdigest.ui.screens.account

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UserBio(bio: String) {
    Text(
        text = bio,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}