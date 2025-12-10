package com.example.statemachineproject.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TrafficLightScreen(
    state: TrafficLightState,
    onNext:() -> Unit = {}
){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(
                    when(state){
                        // UI Reacts to State change
                        is TrafficLightState.Green-> Color.Green
                        is TrafficLightState.Yellow -> Color.Yellow
                        is TrafficLightState.Red -> Color.Red
                    },
                    shape = CircleShape
                )
        )

        Spacer(Modifier.height(24.dp))

        // button to go to next state
        Button(onClick = onNext) {
            Text("Next")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun TrafficLightScreenPreview(){
    TrafficLightScreen(TrafficLightState.Green)
}