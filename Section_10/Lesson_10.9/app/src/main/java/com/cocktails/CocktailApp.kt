package com.cocktails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun CocktailApp(navController: NavHostController) {

    val cocktailViewModel: MainViewModel = viewModel()
    val viewState by cocktailViewModel.drinkState

    NavHost(navController = navController, startDestination = View.CocktailView.route) {

        composable(route = View.CocktailView.route) {

        }

        composable(route = View.DrinkDetailView.route) {

        }


    }


}