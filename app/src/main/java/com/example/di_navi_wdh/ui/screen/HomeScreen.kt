package com.example.di_navi_wdh.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import com.example.di_navi_wdh.ui.component.AnimalCard
import com.example.di_navi_wdh.ui.component.TitleBar
import com.example.di_navi_wdh.ui.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel
) {

    val animals by homeViewModel.animalList.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TitleBar(modifier, "Home")

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(animals) {
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

