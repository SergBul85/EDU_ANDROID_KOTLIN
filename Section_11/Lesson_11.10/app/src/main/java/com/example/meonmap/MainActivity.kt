package com.example.meonmap

import android.Manifest
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import com.example.meonmap.ui.theme.MeOnMapTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val utils = Utils(context)
            val viewModel = PositionViewModel()

            MeOnMapTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen(utils, context, viewModel)
                }
            }
        }
    }
}

@Composable
fun Screen(utils: Utils, context: Context, viewModel: PositionViewModel) {

    val position = viewModel.position.value

    val rememberLauncherForActivityResult =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestMultiplePermissions(),
            onResult = { permissions ->
                if (permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true &&
                    permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
                ) {
                    utils.requestUpdatePosition(viewModel)
                } else {

                    val shouldShowRequestPermissionRationale =
                        ActivityCompat.shouldShowRequestPermissionRationale(
                            context as MainActivity,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) || ActivityCompat.shouldShowRequestPermissionRationale(
                            context as MainActivity,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                        )

                    if (shouldShowRequestPermissionRationale) {
                        Toast.makeText(
                            context, "You need to TURN ON LOCATION for this app!",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(
                            context, "You must to TURN ON LOCATION for this app in SETTINGS!",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                }

            }
        )



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        Text(text = "Location is blocked")

        Text("My position is ${position?.latitude}  ${position?.longitude}")
        Spacer(modifier = Modifier.padding(bottom = 8.dp))
        Text("Address: ${position?.let { utils.getAddress(it) }}")

        Spacer(modifier = Modifier.padding(bottom = 8.dp))
        Button(onClick = {

            if (utils.hasPermission(context)) {
                utils.requestUpdatePosition(viewModel)
            } else {
                rememberLauncherForActivityResult.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
            }

        }) {
            Text(text = "Check my position!")
        }

    }
}