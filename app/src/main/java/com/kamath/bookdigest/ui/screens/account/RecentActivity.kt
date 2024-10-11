package com.kamath.bookdigest.ui.screens.account

import androidx.compose.runtime.Composable
import com.kamath.bookdigest.ui.screens.common.SubList

@Composable
fun RecentActivity(activities: List<String>) {
    SubList(
        sectionTitle = "Recent Activity",
        items = activities,
        onItemClick = { /* Handle click */ }
    )
}