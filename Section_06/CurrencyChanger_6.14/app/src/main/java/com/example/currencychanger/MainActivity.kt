package com.example.currencychanger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.currencychanger.ui.theme.CurrencyChangerTheme
import kotlin.math.roundToInt

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

    val inputValue = remember { mutableStateOf("") }
    var isDropDownOpen by remember { mutableStateOf(false) }
    var textOnSelectBtn by remember { mutableStateOf("Select") }
    var rate by remember { mutableDoubleStateOf(0.0) }
    var result by remember { mutableDoubleStateOf(0.0) }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Currency Changer")

        Spacer(modifier = Modifier.height(25.dp))

        //<editor-fold desc="Input field">
        OutlinedTextField(value = inputValue.value,
            label = { Text("Enter amount in Euro") },
            onValueChange = {
                inputValue.value = it
            })
        //</editor-fold>

        Spacer(modifier = Modifier.height(25.dp))

        Row {

            Box {

                //<editor-fold desc="SELECT btn">
                Button(onClick = { isDropDownOpen = true }) {
                    Text(textOnSelectBtn)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
                //</editor-fold>

                //<editor-fold desc="DropdownMenu">
                DropdownMenu(
                    expanded = isDropDownOpen,
                    onDismissRequest = { isDropDownOpen = false }) {
                    DropdownMenuItem(text = { Text("USD - 1.15") }, onClick = {
                        isDropDownOpen = false
                        textOnSelectBtn = "USD - 1.15"
                        result = 0.0
                        rate = 1.15
                    })
                    DropdownMenuItem(text = { Text("UAH - 45.15") }, onClick = {
                        isDropDownOpen = false
                        textOnSelectBtn = "UAH - 45.15"
                        result = 0.0
                        rate = 45.15
                    })
                    DropdownMenuItem(text = { Text("RUB - 123.15") }, onClick = {
                        isDropDownOpen = false
                        textOnSelectBtn = "RUB - 123.15"
                        result = 0.0
                        rate = 123.15
                    })
                }
                //</editor-fold>

            }

            Spacer(modifier = Modifier.width(24.dp))

            Box {

                //<editor-fold desc="Calculate Btn">
                Button(
                    onClick = {

                        result = (inputValue.value.toDouble() * 100).roundToInt() / 100.0

                    }
                ) {
                    Text("Calculate")
                }
                //</editor-fold>

            }

        }

        Spacer(modifier = Modifier.height(25.dp))

        Text("Result: ${result}")

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

