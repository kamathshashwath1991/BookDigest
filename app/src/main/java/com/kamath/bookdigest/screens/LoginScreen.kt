package com.kamath.bookdigest.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kamath.bookdigest.Routes

@Composable
fun LoginScreen(navController: NavController){
    var username by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = username,
            onValueChange = {username = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            label = { Text("Username")},
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email
            ),
            leadingIcon = { Icon(Icons.Default.AccountBox, contentDescription = null) }
        )
        Button(
            onClick = {
                      navController.navigate(Routes.HomeScreen.route){
                          launchSingleTop = true
                      }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 20.dp),
        ) {
            Text(text = "Login")
        }
    }
}