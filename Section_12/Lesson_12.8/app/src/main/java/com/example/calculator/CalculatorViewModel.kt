package com.example.calculator

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    private val _inputField = MutableLiveData("")
    val inputField = _inputField

    private val _resultField = MutableLiveData("")
    val resultField = _resultField

    fun onButtonClick(btnText: String) {

        Log.i("Button \"${btnText}\" was clicked", btnText)

        _inputField.value?.let {

            if (btnText == "AC") {
                _inputField.value = ""
                _resultField.value = "0"
                return
            }

            if (btnText == "C") {
                if (it.isNotEmpty()) {
                    _inputField.value = it.substring(0, it.length - 1)
                    _resultField.value = ""
                }
                return
            }

            if (btnText == "=") {
                _inputField.value = calculateResult(_inputField.value.toString())
                return
            }

            _inputField.value = it + btnText
            _resultField.value = calculateResult(_inputField.value.toString())

        }


    }

    private fun calculateResult(value: String): String {

        return "777"
    }

}