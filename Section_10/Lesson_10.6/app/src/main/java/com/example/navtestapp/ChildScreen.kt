package com.example.navtestapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ChildScreen(text: String, navToParentScreen: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Child Screen", fontSize = 36.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.padding(8.dp))

        Text(text, fontSize = 36.sp)
        Spacer(modifier = Modifier.padding(8.dp))

        Button(onClick = { navToParentScreen() }) {
            Text("Go to Parent screen", fontSize = 28.sp)
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun ChildScreenPreview() {
    ChildScreen("Any text", {})
}
