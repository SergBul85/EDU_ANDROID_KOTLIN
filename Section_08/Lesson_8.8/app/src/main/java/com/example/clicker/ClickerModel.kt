package com.example.clicker

data class ClickerModel(var point: Int)

class ClickerRepository {

    private var _pointQuantity = ClickerModel(0)

    fun getPoint() = _pointQuantity

    fun plusPoint() {
        _pointQuantity.point++
    }

    fun minusPoint() {
        _pointQuantity.point--
    }


}