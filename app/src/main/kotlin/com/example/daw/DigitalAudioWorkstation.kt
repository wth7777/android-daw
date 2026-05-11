package com.example.daw

import android.content.Context
import androidx.compose.ui.tooling.preview.Preview
import com.example.daw.ui.PianoRoll
import com.example.daw.ui.RackCard

class DigitalAudioWorkstation(context: Context) {
    init {
        // Activate audio thread via Oboe (low-latency)
        // JNI call to nativeInit() will happen when we actually start audio
    }

    /** Synchronous JNI bridge functions */
    external fun nativeStart();          // starts Oboe audio thread
    external fun nativeStop();            // stops audio thread
    external fun nativeNoteTrigger(frequency: Int, noteId: Int)
    external fun nativeSetParameter(parameterId: Int, value: Float)

    /** Public API ------------------------------------------------- */
    fun startMusic() = nativeStart()
    fun stopMusic() = nativeStop()
}