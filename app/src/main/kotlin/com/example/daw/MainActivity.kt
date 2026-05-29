package com.example.daw

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val textView = TextView(this)
        textView.text = "DAW App - Basic APK Ready!"
        textView.textSize = 24f
        textView.setPadding(50, 50, 50, 50)
        
        setContentView(textView)
    }
}