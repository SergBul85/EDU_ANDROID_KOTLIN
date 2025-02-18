package com.example.sharedpref

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sharedpref.ui.theme.SharedPrefTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SharedPrefTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {

    val context = LocalContext.current
    val spm: SharedPrefManager = SharedPrefManager(context)

    var userName by remember {
        mutableStateOf(spm.getString("name"))
    }
    var userAge by remember {
        mutableStateOf(spm.getInt("age"))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Save data APP", fontSize = 30.sp)
        Text(text = "Name: $userName", fontSize = 30.sp)
        Text(text = "Age: $userAge", fontSize = 30.sp)

        Spacer(modifier = Modifier.padding(16.dp))

        var newUserName by remember {
            mutableStateOf("")
        }
        var newUserAge by remember {
            mutableStateOf("")
        }

        TextField(
            value = newUserName,
            onValueChange = { newUserName = it },
            label = { Text("Enter name") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next)
        )
        Spacer(modifier = Modifier.padding(8.dp))

        TextField(
            value = newUserAge,
            onValueChange = { newUserAge = it },
            label = { Text("Enter ag") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Button(onClick = {

            spm.saveString("name", newUserName)
            spm.saveInt("age", newUserAge.toInt())

            userName = newUserName
            userAge = newUserAge.toInt()

            newUserName = ""
            newUserAge = ""

        }) {
            Text(text = "Update data", fontSize = 26.sp)
        }

    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview() {
    MyApp()
}
