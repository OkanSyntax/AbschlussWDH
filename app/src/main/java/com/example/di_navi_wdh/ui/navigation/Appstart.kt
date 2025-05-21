package com.example.di_navi_wdh.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.di_navi_wdh.ui.screen.FavoriteScreen
import com.example.di_navi_wdh.ui.screen.HomeScreen
import com.example.di_navi_wdh.ui.screen.SettingsScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

@Serializable
object SettingsRoute

@Serializable
object FavoriteRoute


@Composable
fun Appstart(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    var selectedTabItem by remember { mutableStateOf(NavItems.Home) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavItems.entries.forEach { navItem ->
                    NavigationBarItem(
                        selected = navItem == selectedTabItem,
                        onClick = {
                            selectedTabItem = navItem
                            navController.navigate(navItem.route)
                        },
                        icon = {Icon(navItem.icon, navItem.name)}
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HomeRoute,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<HomeRoute> {
                HomeScreen()
            }
            composable<FavoriteRoute> {
                FavoriteScreen()
            }
            composable<SettingsRoute> {
                SettingsScreen()
            }
        }
    }
}

