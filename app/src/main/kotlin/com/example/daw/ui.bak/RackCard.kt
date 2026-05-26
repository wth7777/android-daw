package com.example.daw.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun RackCard(
    title: String,
    type: String,
    modifier: Modifier = Modifier
) {
    var isActive by remember { mutableStateOf(false) }
    
    Card(
        modifier = modifier
            .height(100.dp)
            .clickable { isActive = !isActive },
        backgroundColor = if (isActive) Color(0xFF2D2D2D) else Color(0xFF1E1E1E),
        border = if (isActive) {
            androidx.compose.foundation.BorderStroke(2.dp, Color.Cyan)
        } else {
            androidx.compose.foundation.BorderStroke(1.dp, Color.Gray)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            
            Text(
                text = type,
                style = MaterialTheme.typography.caption,
                color = Color.Gray
            )
            
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .background(
                        if (isActive) Color.Green else Color.Red,
                        shape = androidx.compose.foundation.shape.CircleShape
                    )
            )
        }
    }
}