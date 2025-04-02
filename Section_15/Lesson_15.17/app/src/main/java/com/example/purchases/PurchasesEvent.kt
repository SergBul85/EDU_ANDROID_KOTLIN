package com.example.purchases

import com.example.purchases.db.Purchase

sealed interface PurchasesEvent {

    object SortPurchases : PurchasesEvent

    data class DeletePurchase(
        val purchase: Purchase
    ) : PurchasesEvent

    data class SavePurchase(
        val description: String,
        val amount: Float
    ) : PurchasesEvent

}