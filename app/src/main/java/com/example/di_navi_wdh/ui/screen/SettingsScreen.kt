package com.example.di_navi_wdh.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import com.example.di_navi_wdh.R
import androidx.compose.ui.unit.dp
import com.example.di_navi_wdh.audio.mediaplayer.rememberMediaPlayerManager
import com.example.di_navi_wdh.ui.component.TitleBar

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier
) {
    val mediaPlayerManager = rememberMediaPlayerManager()

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayerManager.stop()
        }
    }

    Column (
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TitleBar(modifier, "Settings", onClick = {if (mediaPlayerManager.isPlaying()){
            mediaPlayerManager.stop()
        } else{
        mediaPlayerManager.play(
            resId = R.raw.background,
            loop = false
        )
        }
        })
        Text("Volume")
        Text("Profile")
        Text("Dev Mode")
    }
}

