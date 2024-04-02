package com.kamath.bookdigest.ui.screens.accountScreenComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonsRow(
    onEditClick: () -> Unit,
    onMyBooksClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Button(
            onClick = { onEditClick() },
            modifier = Modifier.weight(1f).padding(2.dp)
        ) {
            Text(text = "Edit")
        }
        Button(
            onClick = { onMyBooksClick() },
            modifier = Modifier.weight(1f).padding(2.dp)
        ) {
            Text(text = "My Books")
        }
    }
}
