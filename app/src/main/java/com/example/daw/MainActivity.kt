package com.example.daw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import com.example.daw.ui.PianoRoll
import com.example.daw.ui.RackCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = FillMaxSize) {
                    var showPiano by remember { mutableStateOf(true) }
                    Column {
                        // Top bar
                        TopAppBar(title = { Text("DAW - Studio in your pocket") })
                        // Toggle between Piano Roll and Rack
                        Row(modifier = FillMaxWidth, horizontalArrangement = Arrangement.Center) {
                            Button(onClick = { showPiano = true }) { Text("Piano Roll") }
                            Spacer(modifier = Width(16.dp))
                            Button(onClick = { showPiano = false }) { Text("Rack") }
                        }
                        // Main content
                        if (showPiano) {
                            PianoRollPreview()
                        } else {
                            RackPreview()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PianoRollPreview() {
    // Simple placeholder for PianoRoll; we'll wire the real view later
    Box(modifier = FillMaxSize, contentAlignment = Alignment.Center) {
        Text("Piano Roll - Tap to add notes")
        // You can replace with AndroidView { PianoRoll(it) } if needed
    }
}

@Composable
fun RackPreview() {
    Column(modifier = FillMaxSize.padding(16.dp)) {
        Text("Modular Rack", style = MaterialTheme.typography.h5)
        Spacer(modifier = Height(16.dp))
        RackCard(title = "PolySynth", type = "Synth") { freq -> /* trigger note */ }
        Spacer(modifier = Height(8.dp))
        RackCard(title = "808 Drum", type = "Drum") { note -> /* trigger drum */ }
    }
}
