package com.kamath.bookdigest.ui.screens

import AccountScreen
import ScanBarcode
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kamath.bookdigest.ui.screens.common.BookDetailsScreen
import com.kamath.bookdigest.utility.BarcodeScanner

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController(), barcodeScanner: BarcodeScanner) {


    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("scan") {
            ScanBarcode(
                navController = navController,
                onScanBarcode = { barcodeScanner.startScan() },
                barcodeValue = barcodeScanner.barCodeResults.collectAsStateWithLifecycle().value
            )
        }
        composable("account") {
            AccountScreen(
                name = "Your Name",
                username = "yourusername",
                bio = "Your bio here",
                bookListed = 100,
                following = 200,
                followers = 300,
                currentBook = "Current Book Title",
                booksReadThisYear = 15,
                yearlyGoal = 50,
                recentActivities = listOf("Added Book X", "Finished Book Y", "Wrote review for Book Z"),
                favoriteGenres = listOf("Science Fiction", "Mystery", "Fantasy")
            )
        }
        composable("bookDetails/{isbn}") { backStackEntry ->
            val bookId = backStackEntry.arguments?.getString("isbn")
            BookDetailsScreen(navController,bookId = bookId)
        }
        composable("sell") {
            SellScreen()
        }
    }
}