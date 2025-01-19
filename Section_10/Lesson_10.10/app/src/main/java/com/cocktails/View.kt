package com.cocktails

sealed class View(val route: String) {

    object CocktailView : View("cocktailview")
    object DrinkDetailView : View("drinkdetailview")

}