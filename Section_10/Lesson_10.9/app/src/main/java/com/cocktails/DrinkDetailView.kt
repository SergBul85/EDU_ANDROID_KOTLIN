package com.cocktails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter


@Composable
fun DrinkDetailView(drink: Drink) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = drink.strDrink, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.padding(8.dp))

        Image(
            painter = rememberAsyncImagePainter(drink.strDrinkThumb),
            contentDescription = "Drink image",
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Text(text = drink.strCategory, textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = drink.strInstructions,
            textAlign = TextAlign.Justify,
            fontStyle = FontStyle.Italic
        )

    }
}