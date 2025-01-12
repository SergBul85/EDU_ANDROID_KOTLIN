package com.cocktails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CocktailView(modifier: Modifier = Modifier) {
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


            }
        }
    }
}