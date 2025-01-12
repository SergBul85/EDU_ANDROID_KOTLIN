package com.example.json


data class Car(
    val model: String,
    val color: String,
    val speed: Int,
    val isBrooken: Boolean
)

fun main() {

    val car1 = Car("Audi", "Black", 150, false)
    val car2 = Car("BMW", "Blue", 175, true)
    val car3 = Car("Honda", "While", 125, false)

    val cars = listOf(car1, car2, car3)

    println(cars)


}


