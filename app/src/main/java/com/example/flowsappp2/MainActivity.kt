package com.example.flowsappp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.flowsappp2.presentation.WeatherScreen
import com.example.flowsappp2.ui.theme.FlowsAppp2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlowsAppp2Theme {
                WeatherScreen(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}


/*
Flow
    Cold (does not emit until something is collecting)
StateFlow
    Requires initial value
    Hot (always emits a value)
    Only stores most recent value
SharedFlow
    Does not require initial value
    Hot
    Configurable replay
Channels
    Used when there is communication between two coroutines
    Communication pattern
    Unicast. One to one (only able to broadcast to one receiver)
    Does not have an initial state
    Events are queued and then discarded
    Hot (emit data even without a receiver)
    Must be closed manually
 */