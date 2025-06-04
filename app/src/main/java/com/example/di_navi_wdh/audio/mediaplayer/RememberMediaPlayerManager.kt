package com.example.di_navi_wdh.audio.mediaplayer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun rememberMediaPlayerManager(): MediaPlayerManager {
    val context = LocalContext.current
    return remember { MediaPlayerManager(context) }
}

