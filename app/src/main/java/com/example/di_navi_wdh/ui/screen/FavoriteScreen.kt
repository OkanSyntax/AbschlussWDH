package com.example.di_navi_wdh.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import com.example.di_navi_wdh.ui.component.AnimalCard
import com.example.di_navi_wdh.ui.component.TitleBar
import com.example.di_navi_wdh.ui.viewmodel.FavoriteViewModel
import com.example.di_navi_wdh.ui.viewmodel.HomeViewModel

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    favoriteViewModel: FavoriteViewModel,
    homeViewModel: HomeViewModel
) {
    val favoriteList by favoriteViewModel.favoriteList.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TitleBar(modifier, "Favorite")

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(favoriteList) {
                AnimalCard(
                    animal = it,
                    modifier = modifier,
                    onFavorite = {
                        homeViewModel.toggleFavorite(it)
                    }
                )
            }
        }

    }
}
