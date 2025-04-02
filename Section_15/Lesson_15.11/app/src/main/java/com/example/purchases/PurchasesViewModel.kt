package com.example.purchases

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.purchases.db.PurchaseDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PurchasesViewModel(
    private val dao: PurchaseDao
) : ViewModel() {

    private val isSortedByDateAdded = MutableStateFlow(true)

    fun onEvent(event: PurchasesEvent) {

        when (event) {
            is PurchasesEvent.DeletePurchase -> {
                viewModelScope.launch {
                    dao.deletePurchase(event.purchase)
                }
            }

            is PurchasesEvent.SavePurchase -> {

            }

            PurchasesEvent.SortPurchases -> {
                isSortedByDateAdded.value = !isSortedByDateAdded.value
            }
        }
    }
}