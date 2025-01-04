package com.example.currencychanger

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.currencychanger.ui.theme.CurrencyChangerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyChangerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConverterChanger()
                }
            }
        }
    }
}

@Composable
fun ConverterChanger() {
    Column {
        Text("Currency Changer")
        OutlinedTextField(value = "",
            label = { Text("Enter your data") },
            onValueChange = {})
        Row {
            val context = LocalContext.current

            // Эта часть кода отвечает за кнопку
            Button(onClick = {
                Toast.makeText(context, "You click a button!", Toast.LENGTH_LONG).show()
            }) {
                Text("Calculate it")
            }


        }
    }
}

@Preview(showBackground = false, showSystemUi = true)
@Composable
fun ConverterChangerPreview() {
    ConverterChanger()
}

//@Composable
//fun Greeting(text: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "$text!",
//        modifier = modifier
//    )
//}

