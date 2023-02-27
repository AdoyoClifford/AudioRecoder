package com.adoyo.audiorecoder.playback

import java.io.File

interface AudioPlayer {
    fun play(file: File)
    fun stop()
}