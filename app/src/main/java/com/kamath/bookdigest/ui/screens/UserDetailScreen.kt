package com.kamath.bookdigest.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kamath.bookdigest.viewModels.UserViewModel

@Composable
fun UserDetailScreen(userId:String, userViewModel: UserViewModel = hiltViewModel()){

    LaunchedEffect(userId) {
        userViewModel.getUserById(userId)
    }
    val user by userViewModel.userList.observeAsState(emptyList())

    Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "User Details", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "Name: ${user.get(userId.toInt())}")
//            Text(text = "Email: ${user.rating}")
            // Add other details as needed
        }


}