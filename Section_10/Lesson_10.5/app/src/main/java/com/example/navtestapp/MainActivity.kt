package com.example.navtestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navtestapp.ui.theme.NavTestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavTestAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationFun()
                }
            }
        }
    }
}

@Composable
fun NavigationFun() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "childScreen") {

        composable("parentScreen") {
            ParentScreen {
                navController.navigate("childScreen")
            }
        }

        composable(route = "childScreen") {
            ChildScreen {
                navController.navigate("parentScreen")
            }
        }

    }

}