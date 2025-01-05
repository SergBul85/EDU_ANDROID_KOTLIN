package com.example.example_08

fun main() {

// ----------------------------- MAP --------------------------------------

//    val numbers = listOf(1, 2, 3, 4, 5)
//    var newNumbers = mutableListOf<Int>()
//
//    for (it in numbers) {
//        newNumbers.add(it * 2)
//    }
//    println("New double list: $newNumbers")
//    println("===============================")
//
//    var newNumberMap = numbers.map { it * it }
//    println("New newNumberMap: $newNumberMap")

//    val fruits = listOf("Banan", "Apple", "cherry")
//
//    val lengs = fruits.map { it.length }
//    println(lengs)

// ----------------------------- COPY --------------------------------------

//    val car1 = Car("Audi", "Germany", "Black", 220)
//    val car2 = car1.copy(color = "Red", model = "BMW")
//
//    val car3 = Car("Toyota", "Japan", "White", 175)
//    val car4 = Car("Mazda", "Japan", "Yellow", 155)
//
//    val cars = listOf(car1, car2, car3, car4)
//
//    val updatedCars = cars.map { it.copy(country = "USA") }
//
//    for (car in cars) {
//        println(car)
//    }
//
//    println("=================")
//
//    for (car in updatedCars) {
//        println(car)
//    }

    // ----------------------------- LET --------------------------------------

    println("START")

    val text: String? = "Any long text"

    text?.let {
        println("Length of text ${it.length}")
    }

    println("END")
}


data class Car(val model: String, val country: String, val color: String, val speed: Int)