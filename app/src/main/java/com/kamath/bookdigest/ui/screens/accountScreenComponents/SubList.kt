package com.kamath.bookdigest.ui.screens.accountScreenComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SubList(
    sectionTitle:String,
    items:List<String>,
    onItemClick:(String) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = sectionTitle,
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn{
            this.items(items){item->
                SubListItem(
                    itemName = item,
                    onItemClick = {onItemClick(item)}
                )

            }
        }
    }
    
}

@Composable
fun SubListItem(
    itemName: String,
    onItemClick: () -> Unit
) {
    Text(
        text = itemName,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onItemClick() }
    )
}