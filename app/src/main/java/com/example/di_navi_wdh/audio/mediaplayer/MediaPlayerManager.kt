package com.example.di_navi_wdh.audio.mediaplayer

import android.content.Context
import android.media.MediaPlayer
import androidx.annotation.RawRes


class MediaPlayerManager(private val context: Context) {

    private var mediaPlayer: MediaPlayer? = null

    fun play(@RawRes resId: Int, loop: Boolean = false) {
        stop()
        mediaPlayer = MediaPlayer.create(context, resId)?.apply{
            isLooping = loop
            setOnCompletionListener {
                stop()
            }
            start()
        }
    }

    fun stop() {
        mediaPlayer?.release()
        mediaPlayer = null
    }

    fun isPlaying(): Boolean {
        return mediaPlayer?.isPlaying == true
    }
}