package com.example.daw.ui

import android.content.Context
import android.graphics.*
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * Touch-first Piano Roll view using Compose.
 * - 6 octaves (C2–C7)
 * - 16 steps (1 beat @ 4/4, scalable)
 * - Note tap to add notes
 */
@Composable
fun PianoRollView(modifier: Modifier = Modifier) {
    var notes by remember { mutableStateOf(listOf<NoteData>()) }
    
    val stepWidth = 60f
    val keyHeight = 40f
    
    Box(
        modifier = modifier
            .background(Color.DarkGray)
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    val step = (offset.x / stepWidth).toInt().coerceIn(0, 15)
                    val octave = (offset.y / keyHeight).toInt().coerceIn(0, 5)
                    notes = notes + NoteData(step, octave, 1, Color.Cyan)
                }
            }
    ) {
        AndroidView(
            factory = { context ->
                object : View(context) {
                    override fun onDraw(canvas: Canvas) {
                        super.onDraw(canvas)
                        
                        val gridPaint = Paint().apply {
                            color = Color.Gray
                            strokeWidth = 1f
                        }
                        
                        // Vertical lines (steps)
                        for (i in 0..16) {
                            canvas.drawLine(
                                i * stepWidth, 0f,
                                i * stepWidth, 6 * keyHeight,
                                gridPaint
                            )
                        }
                        
                        // Horizontal lines (keys)
                        for (i in 0..6) {
                            canvas.drawLine(
                                0f, i * keyHeight,
                                16 * stepWidth, i * keyHeight,
                                gridPaint
                            )
                        }
                        
                        // Draw black keys
                        val blackKeyPaint = Paint().apply {
                            color = Color.Black
                        }
                        for (octave in 0..5) {
                            for (i in listOf(1, 3, 6, 8, 10)) {
                                val x = i * stepWidth
                                val y = octave * keyHeight
                                canvas.drawRect(x, y, x + stepWidth * 0.6f, y + keyHeight, blackKeyPaint)
                            }
                        }
                        
                        // Draw white keys
                        val whiteKeyPaint = Paint().apply {
                            color = Color.White
                        }
                        for (octave in 0..5) {
                            for (i in listOf(0, 2, 4, 5, 7, 9, 11)) {
                                val x = i * stepWidth
                                val y = octave * keyHeight
                                canvas.drawRect(x, y, x + stepWidth, y + keyHeight, whiteKeyPaint)
                            }
                        }
                        
                        // Draw notes
                        val notePaint = Paint().apply {
                            color = Color.Cyan
                        }
                        notes.forEach { note ->
                            val left = note.startStep * stepWidth
                            val top = note.octave * keyHeight
                            canvas.drawRect(
                                left, top,
                                left + stepWidth * note.duration,
                                top + keyHeight,
                                notePaint
                            )
                        }
                    }
                }
            },
            update = { view ->
                view.invalidate()
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}

data class NoteData(
    val startStep: Int,
    val octave: Int,
    val duration: Int,
    val color: Color
)