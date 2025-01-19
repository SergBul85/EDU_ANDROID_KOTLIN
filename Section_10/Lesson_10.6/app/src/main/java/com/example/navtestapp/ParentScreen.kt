package com.example.navtestapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ParentScreen(navToChildScreen: (String) -> Unit) {
    val text = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Parent Screen", fontSize = 36.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.padding(8.dp))
        OutlinedTextField(value = text.value, onValueChange = { text.value = it })
        Spacer(modifier = Modifier.padding(8.dp))
        Button(onClick = { navToChildScreen(text.value) }) {
            Text("Go to child screen", fontSize = 28.sp)
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun ParentScreenPreview() {
    ParentScreen({})
}

