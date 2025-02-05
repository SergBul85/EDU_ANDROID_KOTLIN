package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Calculator() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Column() {

        }
        //Input field
        Text(text = "111+222")

        Spacer(modifier = Modifier.height(16.dp))
        //Result field
        Text(text = "333")
        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(columns = GridCells.Fixed(4)) {
            
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun CalculatorPreview() {
    Calculator()
}

