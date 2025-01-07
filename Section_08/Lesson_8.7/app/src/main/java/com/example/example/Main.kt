package com.example.example


fun main() {

    val car1 = Car()
    car1.basicInfoView()
    car1.typeCarView()

    println("----------------------")

    val sportCar1 = SportCar()
    sportCar1.basicInfoView()
    sportCar1.typeCarView()

    println("----------------------")

    val truck1 = Truck()
    truck1.basicInfoView()
    truck1.typeCarView()

}