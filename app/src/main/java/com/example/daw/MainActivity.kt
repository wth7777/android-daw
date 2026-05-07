package com.example.daw

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(50, 50, 50, 50)
        }
        
        val title = TextView(this).apply {
            text = "DAW - Minimal Build"
            textSize = 24f
        }
        
        val status = TextView(this).apply {
            text = "APK builds successfully. DAW UI features will be added back incrementally."
            textSize = 14f
        }
        
        layout.addView(title)
        layout.addView(status)
        
        setContentView(layout)
    }
}