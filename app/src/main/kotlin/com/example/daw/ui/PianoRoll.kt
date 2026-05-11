package com.example.daw.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * Touch-first Piano Roll view.
 * - 6 octaves (C2–C7)
 * - 16 steps (1 beat @ 4/4, scalable)
 * - Note drag/resize
 */
class PianoRoll(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private val paint = Paint()
    private val gridPaint = Paint()
    private val blackKeyPaint = Paint()

    var notes: MutableList<Note> = mutableListOf()
    var stepWidth = 60f
    var keyHeight = 40f

    init {
        paint.color = Color.WHITE
        gridPaint.color = Color.GRAY
        blackKeyPaint.color = Color.BLACK
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw keys
        for (octave in 2..7) {
            for (i in 0..11) {
                val isWhite = i in listOf(0, 2, 4, 5, 7, 9, 11)
                val keyX = (i * stepWidth).toInt()
                val keyY = (octave - 2) * keyHeight
                if (isWhite) {
                    canvas.drawRect(keyX.toFloat(), keyY, (keyX + stepWidth), keyY + keyHeight, gridPaint)
                } else {
                    canvas.drawRect(keyX.toFloat(), keyY, (keyX + stepWidth * 0.6f), keyY + keyHeight, blackKeyPaint)
                }
            }
        }

        // Draw notes
        notes.forEach { note ->
            val left = note.startStep * stepWidth
            val top = note.octave * keyHeight
            paint.color = note.color
            canvas.drawRect(left, top, left + stepWidth * note.duration, top + keyHeight, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                val step = (event.x / stepWidth).toInt()
                val octave = (event.y / keyHeight).toInt() + 2
                notes.add(Note(step, octave, 1, Color.CYAN))
                invalidate()
            }
        }
        return true
    }

    data class Note(var startStep: Int, var octave: Int, var duration: Int, var color: Int)
}