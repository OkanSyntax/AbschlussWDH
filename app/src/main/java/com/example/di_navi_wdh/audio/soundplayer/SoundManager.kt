package com.example.di_navi_wdh.audio.soundplayer

import android.content.Context
import android.media.SoundPool
import com.example.di_navi_wdh.R


class SoundManager(context: Context) {

    private val soundPool: SoundPool = SoundPool.Builder()
        .setMaxStreams(4)
        .build()

    private val soundMap = mutableMapOf<String, Int>()

    init {
        soundMap["Frog"] = soundPool.load(context, R.raw.frog, 1)
        soundMap["Cow"] = soundPool.load(context, R.raw.cow, 1)
        soundMap["Goat"] = soundPool.load(context, R.raw.goat, 1)
        soundMap["Dog"] = soundPool.load(context, R.raw.dog, 1)
    }

    fun playSound(key: String) {
        val soundId = soundMap[key] ?: return
        soundPool.play(soundId, 1f, 1f, 1, 0, 1f)
    }

    fun release() {
        soundPool.release()
    }

}