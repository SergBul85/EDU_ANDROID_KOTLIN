package com.cocktails

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun MainCocktailView(modifier: Modifier = Modifier,
                     navigateToDrinkDetailView: (Drink) -> Unit) {

    val cocktailViewModel: MainViewModel = viewModel()
    val viewState by cocktailViewModel.drinkState

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        when {
            viewState.error != null -> {
                Text("ERROR")
            }

            else -> {
                DrinksView(viewState.list, navigateToDrinkDetailView)
            }
        }
    }
}

@Composable
fun DrinksView(
    drinks: List<Drink>,
    navigateToDrinkDetailView: (Drink) -> Unit
) {
    LazyVerticalGrid(
        GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(drinks) { drink ->
            OneDrink(drink, navigateToDrinkDetailView)
        }
    }
}

@Composable
fun OneDrink(
    drink: Drink,
    navigateToDrinkDetailView: (Drink) -> Unit
) {
    Column(
        modifier = Modifier
            .clickable { navigateToDrinkDetailView(drink) }
            .padding(6.dp)
            .border(width = 1.dp, color = Color.Gray, shape = RectangleShape)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = drink.strDrink,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Image(
            painter = rememberAsyncImagePainter(drink.strDrinkThumb),
            contentDescription = "Drink image",
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )

    }
}
