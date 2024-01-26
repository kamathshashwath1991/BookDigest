package com.kamath.bookdigest

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kamath.bookdigest.data.User

@Composable
fun UserListItem(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = "Listed Book:${user.listedBook.bookTitle}")
            Text(text = "Condition:${user.listedBook.condition}")
            Text(text = "Username: ${user.username}")
            Text(text = "Rating: ${user.rating.toStarRepresentation()}")
        }
    }
}