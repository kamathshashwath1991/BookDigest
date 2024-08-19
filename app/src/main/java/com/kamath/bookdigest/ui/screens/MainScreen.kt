package com.kamath.bookdigest.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Feed
import androidx.compose.material.icons.automirrored.outlined.Feed
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Camera
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.kamath.bookdigest.data.model.TabItem
import com.kamath.bookdigest.utility.BarcodeScanner
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val tabItems = listOf(
        TabItem(title = "Home", unselectedItem = Icons.Outlined.Home, selectedItem = Icons.Filled.Home),
        TabItem(title = "Thread", unselectedItem = Icons.AutoMirrored.Outlined.Feed, selectedItem = Icons.AutoMirrored.Filled.Feed),
        TabItem(title = "Sell", unselectedItem = Icons.Outlined.Camera, selectedItem = Icons.Filled.Camera),
        TabItem(title = "Account", unselectedItem = Icons.Outlined.AccountCircle, selectedItem = Icons.Filled.AccountCircle)
    )

    var selectedTabIndex by remember { mutableIntStateOf(0) }

    // State to manage pager
    val pagerState = rememberPagerState { tabItems.size }
    val context = LocalContext.current
    val barcodeScanner = remember { BarcodeScanner(context) }
    val scope = rememberCoroutineScope()

    // Column to manage layout
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            AppNavHost(navController = navController, barcodeScanner = barcodeScanner,)
        }

        // TabRow at the bottom
        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.padding(top = 8.dp) // Add padding if needed
        ) {
            tabItems.forEachIndexed { index, tabItem ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                        when (index) {
                            0 -> navController.navigate("home")
                            2 -> {
                                navController.navigate("scan")
                                scope.launch {
                                    barcodeScanner.startScan()
                                }
                            }
                            3 -> navController.navigate("account")
                            else -> navController.navigate("home")
                        }
                    },
                    text = { Text(text = tabItem.title) },
                    icon = {
                        Icon(
                            imageVector = if (index == selectedTabIndex) {
                                tabItem.selectedItem
                            } else {
                                tabItem.unselectedItem
                            },
                            contentDescription = tabItem.title
                        )
                    }
                )
            }
        }
    }
}


