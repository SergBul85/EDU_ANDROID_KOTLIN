package com.cocktails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _drinkState = mutableStateOf(CocktailState())
    val drinkState: State<CocktailState> = _drinkState

    init {
        fetchDrink()
    }

    fun fetchDrink() {
        viewModelScope.launch {
            try {
                val response = cocktailService.getDrinks()
                _drinkState.value = _drinkState.value.copy(
                    loading = false,
                    list = response.drinks,
                    error = null
                )
            } catch (e: Exception) {
                _drinkState.value = _drinkState.value.copy(
                    loading = false,
                    error = "Error during loading. Message ${e.message}"
                )
            }
        }
    }

    data class CocktailState(
        val loading: Boolean = true,
        val list: List<Drink> = emptyList(),
        val error: String? = null
    )
}