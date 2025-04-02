package com.example.purchases.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.purchases.PurchaseState
import com.example.purchases.PurchasesEvent

@Composable
fun AddPurchaseScreen(
    state: PurchaseState,
    navController: NavController,
    onEvent: (PurchasesEvent) -> Unit
) {

    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onEvent(
                    PurchasesEvent.SavePurchase(
                        description = state.description.value,
                        amount = state.amount.value.toFloat()
                    )
                )
                navController.popBackStack()
            }) {
                Icon(imageVector = Icons.Rounded.Check, contentDescription = "Save")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .focusRequester(focusRequester),
                value = state.description.value,
                onValueChange = {
                    state.description.value = it
                },
                textStyle = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                placeholder = { Text(text = "Description") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                )

            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                value = state.amount.value.toString(),
                onValueChange = {
                    state.amount.value = it.toFloat()
                },
                textStyle = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                placeholder = { Text(text = "Amount") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                )


            )


        }

    }

}


//@Composable
//@Preview(showSystemUi = true)
//fun AddPurchaseScreenPreview() {
//    AddPurchaseScreen()
//}