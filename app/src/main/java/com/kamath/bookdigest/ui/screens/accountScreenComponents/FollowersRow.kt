package com.kamath.bookdigest.ui.screens.accountScreenComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
@Composable
fun FollowersRow(
    bookListed: Int,
    following: Int,
    followers: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // Book Listed
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Book Listed", color = Color.Gray)
            Text(text = bookListed.toString(), fontSize = 20.sp)
        }

        // Following
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Following", color = Color.Gray)
            Text(text = following.toString(), fontSize = 20.sp)
        }

        // Followers
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Followers", color = Color.Gray)
            Text(text = followers.toString(), fontSize = 20.sp)
        }
    }
}