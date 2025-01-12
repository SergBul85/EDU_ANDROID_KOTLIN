package com.cocktails

data class Drink(
    val strDrink: String,
    val strCategory: String,
    val strDrinkThumb: String,
    val strInstructions: String
)

data class DrinksResponse(val drinks: List<Drink>)
