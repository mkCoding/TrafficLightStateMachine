package com.example.statemachineproject.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TrafficLightViewModel: ViewModel() {
    // create state variable
    private val _trafficLightState = MutableStateFlow<TrafficLightState>(TrafficLightState.Red)
    val trafficLightState = _trafficLightState.asStateFlow()

    // load the data
    // here I decide exactly how states move.
    fun next(){
        _trafficLightState.value = when (_trafficLightState.value) {
            is TrafficLightState.Green -> TrafficLightState.Yellow
            is TrafficLightState.Yellow -> TrafficLightState.Red
            is TrafficLightState.Red -> TrafficLightState.Green
        }
    }

}

// States are clearly defined here
sealed class TrafficLightState {
    object Green: TrafficLightState()
    object Yellow: TrafficLightState()
    object Red: TrafficLightState()
}