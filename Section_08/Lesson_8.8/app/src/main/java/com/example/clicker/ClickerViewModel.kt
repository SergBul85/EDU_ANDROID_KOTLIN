package com.example.clicker

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ClickerViewModel : ViewModel() {

    private val _repository: ClickerRepository = ClickerRepository()
    private val _point = mutableStateOf(_repository.getPoint().point)

    val point: MutableState<Int> = _point

    fun plusOne() {
        _repository.plusPoint()
        _point.value = _repository.getPoint().point
    }

    fun minusOne() {
        _repository.minusPoint()
        _point.value = _repository.getPoint().point
    }

}