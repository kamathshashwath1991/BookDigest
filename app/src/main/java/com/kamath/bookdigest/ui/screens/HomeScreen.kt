package com.kamath.bookdigest.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Feed
import androidx.compose.material.icons.automirrored.outlined.Feed
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Sell
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Camera
import androidx.compose.material.icons.outlined.Feed
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Sell
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.kamath.bookdigest.ui.listItem.UserListItem
import com.kamath.bookdigest.ui.screens.common.TabItem
import com.kamath.bookdigest.viewModels.UserViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavHostController){
    val userViewModel:UserViewModel = hiltViewModel()
    val userList by userViewModel.userList.observeAsState(emptyList())

    val tabItems = listOf<TabItem>(
        TabItem(title = "Home", unselectedItem = Icons.Outlined.Home, selectedItem = Icons.Filled.Home),
        TabItem(title = "Feed", unselectedItem = Icons.AutoMirrored.Outlined.Feed, selectedItem = Icons.AutoMirrored.Filled.Feed),
        TabItem(title = "Sell", unselectedItem = Icons.Outlined.Camera, selectedItem = Icons.Filled.Camera),
        TabItem(title = "Account", unselectedItem = Icons.Outlined.AccountCircle, selectedItem = Icons.Filled.AccountCircle)

    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        var selectedTabIndex by remember {
            mutableIntStateOf(0)
        }
        val pagerState = rememberPagerState {
            tabItems.size
        }
        LaunchedEffect(selectedTabIndex){
            pagerState.animateScrollToPage(selectedTabIndex)
        }
        LaunchedEffect(pagerState.currentPage,pagerState.isScrollInProgress){
            if (!pagerState.isScrollInProgress){
                selectedTabIndex = pagerState.currentPage
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)) {index ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text(text = tabItems[index].title)
            }

        }
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabItems.forEachIndexed { index, tabItem ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = { Text(text = tabItem.title)},
                    icon = {
                        Icon(
                            imageVector = if (index == selectedTabIndex){
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

//        LazyColumn{
//            items(userList) { user ->
//                UserListItem(
//                    user,
//                    onItemClick = { userId -> navController.navigate("userDetail/$userId") }
//                )
//            }
//        }
    }
}