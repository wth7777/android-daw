package com.example.daw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.daw.ui.DAWTheme
import com.example.daw.ui.PianoRollView
import com.example.daw.ui.RackCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            DAWTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        // Top App Bar
                        TopAppBar(
                            title = { Text("DAW - Digital Audio Workstation") },
                            backgroundColor = MaterialTheme.colors.primary
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        // Rack Cards (synth modules)
                        Text("Modules", style = MaterialTheme.typography.h6)
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            RackCard(
                                title = "Synth",
                                type = "oscillator",
                                modifier = Modifier.weight(1f)
                            )
                            RackCard(
                                title = "Filter",
                                type = "lowpass",
                                modifier = Modifier.weight(1f)
                            )
                            RackCard(
                                title = "Amp",
                                type = "envelope",
                                modifier = Modifier.weight(1f)
                            )
                        }
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        // Piano Roll
                        Text("Piano Roll", style = MaterialTheme.typography.h6)
                        Spacer(modifier = Modifier.height(8.dp))
                        PianoRollView(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                        )
                    }
                }
            }
        }
    }
}