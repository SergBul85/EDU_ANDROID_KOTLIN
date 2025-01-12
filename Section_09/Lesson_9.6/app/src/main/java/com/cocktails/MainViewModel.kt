package com.cocktails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _drinkState = mutableStateOf(CocktailState())
    val drinkState: State<CocktailState> = _drinkState

    data class CocktailState(
        val loading: Boolean = true,
        val list: List<Drink> = emptyList(),
        val error: String? = null
    )

}