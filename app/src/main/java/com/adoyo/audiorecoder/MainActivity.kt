package com.adoyo.audiorecoder

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.adoyo.audiorecoder.playback.AudioPlayer
import com.adoyo.audiorecoder.playback.AudioPlayerImpl
import com.adoyo.audiorecoder.record.AudioRecorder
import com.adoyo.audiorecoder.record.AudioRecorderImpl
import com.adoyo.audiorecoder.ui.theme.AudioRecoderTheme
import java.io.File

class MainActivity : ComponentActivity() {

    private val recorder by lazy {
        AudioRecorderImpl(applicationContext)
    }

    private val player by lazy {
        AudioPlayerImpl(applicationContext)
    }

    private var audioFile: File? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCompat.requestPermissions(
            this, arrayOf(Manifest.permission.RECORD_AUDIO),
            0
        )
        setContent {
            AudioRecoderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(onClick = {
                            File(cacheDir, "audio.mp3").also {
                                recorder.start(it)
                                audioFile = it
                            }
                        }) {
                            Text(text = "Start Recording")
                        }

                        Button(onClick = {
                            recorder.stop()
                        }) {
                            Text(text = "Stop Recording")
                        }

                        Button(onClick = {
                            player.playFile(audioFile ?: return@Button)
                        }) {
                            Text(text = "Play")
                        }

                        Button(onClick = {
                            player.stop()
                        }) {
                            Text(text = "Stop playing")
                        }
                    }
                }
            }
        }
    }
}

