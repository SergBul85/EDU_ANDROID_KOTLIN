package com.example.funandclass

fun main() {

    val pupilAndrey = PupilMathInfo("Andrey")
    val pupilBoris = PupilMathInfo("Boris")

    pupilAndrey.setNewMark(5)
    pupilBoris.setNewMark(4)
    pupilAndrey.setNewMark(4)
    pupilAndrey.setNewMark(3)
    pupilBoris.setNewMark(5)
    pupilAndrey.setNewMark(5)
    pupilBoris.setNewMark(3)
    pupilAndrey.setNewMark(5)

    println(pupilAndrey.toString())
    pupilAndrey.showAllMarks()

    println("------------------------------")

    println(pupilBoris)
    pupilBoris.showAllMarks()


}

