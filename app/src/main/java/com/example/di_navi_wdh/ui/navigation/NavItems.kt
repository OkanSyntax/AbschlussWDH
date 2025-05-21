package com.example.di_navi_wdh.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector


enum class NavItems(
    val route: Any,
    val label: String,
    val icon: ImageVector
) {
    Home(
        route = HomeRoute,
        label = "Home",
        icon = Icons.Default.Home
    ),
    Favorite(
        route = FavoriteRoute,
        label = "Favorite",
        icon = Icons.Default.Favorite
    ),
    Settings(
        route = SettingsRoute,
        label = "Settings",
        icon = Icons.Default.Settings
    )
}