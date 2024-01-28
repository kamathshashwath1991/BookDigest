package com.kamath.bookdigest.ui.listItem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kamath.bookdigest.data.model.User
import com.kamath.bookdigest.utility.toStarRepresentation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListItem(user: User, onItemClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = { onItemClick(user.id) }
    ){
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