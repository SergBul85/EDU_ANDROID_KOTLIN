package com.example.clicker

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ClickerViewModel : ViewModel() {

    private val _point = mutableStateOf(0)

    val point: MutableState<Int> = _point

    fun plusOne() {
        _point.value++
    }

    fun minusOne() {
        _point.value--
    }

}