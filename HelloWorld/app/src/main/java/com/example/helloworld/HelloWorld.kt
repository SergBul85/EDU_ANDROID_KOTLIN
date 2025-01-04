package com.example.helloworld

fun main() {

    //Message for user
    println("Please, enter your age")
    val age = readln().toInt()
// in until ..
    if (age in 18 until 100) {
        println("You can buy a beer")
    } else {
        println("You can buy a milk")
    }

}