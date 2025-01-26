package com.example.meonmap

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PositionViewModel : ViewModel() {

    private val _position = mutableStateOf<PositionData?>(null)
    val position: State<PositionData?> = _position

    fun updatePosition(newPosition: PositionData) {
        _position.value = newPosition
    }

}