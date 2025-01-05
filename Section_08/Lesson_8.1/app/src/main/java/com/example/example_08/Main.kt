package com.example.example_08

fun main() {

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

    val fruits = listOf("Banan", "Apple", "cherry")

    val lengs = fruits.map { it.length }
    println(lengs)

}