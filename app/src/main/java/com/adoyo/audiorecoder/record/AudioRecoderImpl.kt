package com.adoyo.audiorecoder.record

import android.content.Context
import android.media.MediaRecorder
import android.os.Build
import java.io.File

class AudioRecorderImpl(
    private val context: Context
): AudioRecorder {
    private var recorder: MediaRecorder? = null

    private fun createRecorder(): MediaRecorder {
        return if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            MediaRecorder(context)
        } else {
            MediaRecorder()
        }
    }
    override fun start(outPutFile: File) {

    }

    override fun stop() {
        TODO("Not yet implemented")
    }

}