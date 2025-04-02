package com.example.purchases

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import com.example.purchases.db.Purchase

data class PurchaseState(
    val purchases: List<Purchase> = emptyList(),

    val description: MutableState<String> = mutableStateOf(""),
    val amount: MutableState<Float> = mutableFloatStateOf(0.0f)
)
