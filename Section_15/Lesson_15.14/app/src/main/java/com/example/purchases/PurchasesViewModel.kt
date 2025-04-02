package com.example.purchases

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.purchases.db.Purchase
import com.example.purchases.db.PurchaseDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PurchasesViewModel(
    private val dao: PurchaseDao
) : ViewModel() {

    private val isSortedByDateAdded = MutableStateFlow(true)

    private var purchases =
        isSortedByDateAdded.flatMapLatest { sort ->
            if (sort) {
                dao.getPurchasesOrderedByDateAddedAsc()
            } else {
                dao.getPurchasesOrderedByDateAddedDesc()
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    val _state = MutableStateFlow(PurchaseState())

    val state =
        combine(_state, isSortedByDateAdded, purchases) { state, isSortedByDateAdded, purchases ->
            state.copy(
                purchases = purchases
            )
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), PurchaseState())

    fun onEvent(event: PurchasesEvent) {

        when (event) {
            is PurchasesEvent.DeletePurchase -> {
                viewModelScope.launch {
                    dao.deletePurchase(event.purchase)
                }
            }

            is PurchasesEvent.SavePurchase -> {
                val purchase = Purchase(
                    description = state.value.description.value,
                    amount = state.value.amount.value.toFloat(),
                    date = System.currentTimeMillis()
                )
                viewModelScope.launch {
                    dao.upsertPurchase(purchase)
                }
                _state.update {
                    it.copy(
                        description = mutableStateOf("")
                    )
                }
            }

            PurchasesEvent.SortPurchases -> {
                isSortedByDateAdded.value = !isSortedByDateAdded.value
            }
        }
    }
}