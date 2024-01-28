package com.kamath.bookdigest.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.kamath.bookdigest.ui.listItem.UserListItem
import com.kamath.bookdigest.viewModels.UserViewModel

@Composable
fun HomeScreen(navController: NavHostController){
    val userViewModel:UserViewModel = hiltViewModel()
    val userList by userViewModel.userList.observeAsState(emptyList())


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        LazyColumn{
            items(userList) { user ->
                UserListItem(
                    user,
                    onItemClick = { userId -> navController.navigate("userDetail/$userId") }
                )
            }
        }
    }
}