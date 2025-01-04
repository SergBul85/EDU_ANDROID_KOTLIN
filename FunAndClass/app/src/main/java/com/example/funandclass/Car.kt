package com.example.funandclass

class Car constructor(var model: String, var speed: Int = 100) {

//    init {
//        move(model)
//    }
//
//    fun move(model: String) = println("I drive my car $model!")

    override fun toString(): String {
        return "Car(model='$model', speed=$speed)"
    }

}