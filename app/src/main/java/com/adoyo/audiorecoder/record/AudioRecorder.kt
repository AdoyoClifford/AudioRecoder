package com.adoyo.audiorecoder.record

import java.io.File

interface AudioRecorder {
    fun start(outPutFile: File)
    fun stop()
}