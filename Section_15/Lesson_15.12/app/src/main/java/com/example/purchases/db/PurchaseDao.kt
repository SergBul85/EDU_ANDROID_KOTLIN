package com.example.purchases.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface PurchaseDao {
//    @Insert
//    fun insertPurchase(purchase: Purchase)
//
//    @Update
//    fun updatePurchase(purchase: Purchase)

    @Upsert
    suspend fun upsertPurchase(purchase: Purchase)

    @Delete
    suspend fun deletePurchase(purchase: Purchase)

    @Query("SELECT * FROM Purchase ORDER BY date ASC")
    fun getPurchasesOrderedByDateAddedAsc(): Flow<List<Purchase>>

    @Query("SELECT * FROM Purchase ORDER BY date DESC")
    fun getPurchasesOrderedByDateAddedDesc(): Flow<List<Purchase>>

}