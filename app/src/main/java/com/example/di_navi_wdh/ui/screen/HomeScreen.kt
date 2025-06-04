package com.example.di_navi_wdh.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import com.example.di_navi_wdh.R
import androidx.compose.ui.unit.dp
import com.example.di_navi_wdh.audio.mediaplayer.rememberMediaPlayerManager
import com.example.di_navi_wdh.audio.soundplayer.rememberSoundManager
import com.example.di_navi_wdh.ui.component.AnimalCard
import com.example.di_navi_wdh.ui.component.TitleBar
import com.example.di_navi_wdh.ui.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel
) {
    val soundManager = rememberSoundManager()
    val mediaPlayerManager = rememberMediaPlayerManager()

    val animals by homeViewModel.animalList.collectAsState()

    DisposableEffect(Unit) {
        onDispose {
            soundManager.release()
            mediaPlayerManager.stop()
        }
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TitleBar(modifier, "Home", onClick = {if(mediaPlayerManager.isPlaying()) {
            mediaPlayerManager.stop()
        } else{
            mediaPlayerManager.play(
                resId = R.raw.background,
                loop = false
            )
        }
        })

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(animals) {
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

