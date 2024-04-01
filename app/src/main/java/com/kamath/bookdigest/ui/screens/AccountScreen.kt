package com.kamath.bookdigest.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kamath.bookdigest.R

@Composable
fun AccountScreen(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Profile Image
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null, // decorative
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Name and Username
            Column {
                Text(
                    text = "Your Name",
                    style = MaterialTheme.typography.displayLarge,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Text(
                    text = "@yourusername",
                    style = MaterialTheme.typography.displaySmall,
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End
        ){
            Button(
                onClick = { /* Handle edit button click */ },
                modifier = Modifier.weight(1f).padding(2.dp)
            ) {
                Text(text = "Edit")
            }
            Button(
                onClick = { /* Handle edit button click */ },
                modifier = Modifier.weight(1f).padding(2.dp)
            ) {
                Text(text = "My Books")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Book Listed
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Book Listed", color = Color.Gray)
                Text(text = "100", fontSize = 20.sp)
            }

            // Following
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Following", color = Color.Gray)
                Text(text = "200", fontSize = 20.sp)
            }

            // Followers
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Followers", color = Color.Gray)
                Text(text = "300", fontSize = 20.sp)
            }
        }

    }

}