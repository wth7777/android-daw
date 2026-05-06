package com.example.daw.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RackCard(
    title: String,
    type: String = "Synth",
    onNoteTrigger: (note: Int) -> Unit = {}
) {
    var isPlaying by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "$title ($type)", style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(8.dp))
            when (type) {
                "Synth" -> {
                    var freq by remember { mutableStateOf(440) }
                    Slider(
                        value = freq.toFloat(),
                        onValueChange = { freq = it.toInt() },
                        valueRange = 20f..20000f
                    )
                    Button(onClick = { onNoteTrigger(freq) }) {
                        Text("Trigger")
                    }
                }
                "Drum" -> {
                    Row {
                        listOf("Kick", "Snare", "HiHat").forEach { drum ->
                            Button(
                                onClick = { onNoteTrigger(drum.hashCode()) },
                                modifier = Modifier.padding(4.dp)
                            ) {
                                Text(drum)
                            }
                        }
                    }
                }
            }
        }
    }
}