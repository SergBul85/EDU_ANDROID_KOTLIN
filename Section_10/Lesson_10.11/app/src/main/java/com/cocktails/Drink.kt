package com.cocktails

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Drink(
    val strDrink: String,
    val strCategory: String,
    val strDrinkThumb: String,
    val strInstructions: String
):Parcelable

data class DrinksResponse(val drinks: List<Drink>)
