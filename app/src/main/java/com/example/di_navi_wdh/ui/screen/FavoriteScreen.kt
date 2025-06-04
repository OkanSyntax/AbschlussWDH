package com.example.di_navi_wdh.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import com.example.di_navi_wdh.R
import androidx.compose.ui.unit.dp
import com.example.di_navi_wdh.audio.mediaplayer.rememberMediaPlayerManager
import com.example.di_navi_wdh.audio.soundplayer.rememberSoundManager
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
    val soundManager = rememberSoundManager()
    val mediaPlayerManager = rememberMediaPlayerManager()

    DisposableEffect(Unit) {
        onDispose {
            soundManager.release()
            mediaPlayerManager.stop()
        }
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TitleBar(modifier, "Favorites", onClick = { if (mediaPlayerManager.isPlaying()) {
            mediaPlayerManager.stop()
        } else {
            mediaPlayerManager.play(
                resId = R.raw.background,
                loop = true
            )
        }})

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(favoriteList) {
                AnimalCard(
                    animal = it,
                    modifier = modifier,
                    onClick = {soundManager.playSound(it.name)},
                    onFavorite = {
                        homeViewModel.toggleFavorite(it)
                    }
                )
            }
        }

    }
}
