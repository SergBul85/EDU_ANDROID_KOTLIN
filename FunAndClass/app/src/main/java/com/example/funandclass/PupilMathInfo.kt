package com.example.funandclass

class PupilMathInfo(var name: String) {

    private val markList = mutableListOf<Int>()

    fun setNewMark(newMark: Int) {
        markList.add(newMark)
    }

    fun avgMark(): Double {
        var sumOfMarks = 0
        val result: Double

        for (oneMark in markList) {
            sumOfMarks += oneMark
        }
        result = sumOfMarks / markList.size.toDouble()
        return result
    }

    fun showAllMarks() {
        println("All mark of pupil $name are: $markList")
    }

    override fun toString(): String {
        return "PupilMathInfo(name='$name', avg mark - ${avgMark()})"
    }


}