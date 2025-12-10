package com.example.statemachineproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.statemachineproject.presentation.TrafficLightScreen
import com.example.statemachineproject.presentation.TrafficLightViewModel
import com.example.statemachineproject.ui.theme.StateMachineProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StateMachineProjectTheme {
                val viewModel: TrafficLightViewModel = viewModel()
                val state by viewModel.trafficLightState.collectAsState()
                val next = {viewModel.next()}
                TrafficLightScreen(state,  onNext = next )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StateMachineProjectTheme {
        Greeting("Android")
    }
}