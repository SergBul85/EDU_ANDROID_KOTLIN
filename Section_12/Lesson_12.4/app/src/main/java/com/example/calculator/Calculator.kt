package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val buttons = listOf(
    "C", "(", ")", "/",
    "7", "8", "9", "*",
    "4", "5", "6", "+",
    "1", "2", "3", "-",
    "AC", "0", ".", "="
)


@Composable
fun Calculator() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            //Input field
            Text(text = "111+222")

            Spacer(modifier = Modifier.height(16.dp))
            //Result field
            Text(text = "333")
            Spacer(modifier = Modifier.weight(1f))

            //Buttons
            LazyVerticalGrid(columns = GridCells.Fixed(4)) {
                items(buttons) {
                    ButtonView(it)
                }
            }
        }

    }
}


@Composable
fun ButtonView(textOnButton: String) {
    Box() {
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Text(
                text = textOnButton,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Composable
@Preview(showSystemUi = true)
fun CalculatorPreview() {
    Calculator()
}

