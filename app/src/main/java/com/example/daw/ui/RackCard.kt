package com.example.daw.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun RackCard(title: String, type: String, onNoteTrigger: (note: Int) -> Unit) {
    Text(text = "RackCard: $title")
}
