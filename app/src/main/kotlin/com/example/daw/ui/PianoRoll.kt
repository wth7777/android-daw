package com.example.daw.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Simple Piano Roll using pure Compose
 * 6 octaves, 16 steps, tap to add notes
 */
@Composable
fun PianoRollView(modifier: Modifier = Modifier) {
    var notes by remember { mutableStateOf(setOf<Pair<Int, Int>>()) }
    
    val stepWidth = 40.dp
    val keyHeight = 30.dp
    
    Column(
        modifier = modifier
            .background(Color.DarkGray)
            .padding(4.dp)
    ) {
        for (octave in 5 downTo 0) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                for (step in 0..15) {
                    val hasNote = notes.contains(octave to step)
                    val bgColor = if (hasNote) Color.Cyan 
                        else if (step % 4 == 0) Color.White.copy(alpha = 0.3f) 
                        else Color.Gray.copy(alpha = 0.2f)
                    
                    Box(
                        modifier = Modifier
                            .width(stepWidth)
                            .height(keyHeight)
                            .background(bgColor)
                            .clickable {
                                notes = if (hasNote) {
                                    notes - (octave to step)
                                } else {
                                    notes + (octave to step)
                                }
                            }
                    )
                }
            }
        }
    }
}