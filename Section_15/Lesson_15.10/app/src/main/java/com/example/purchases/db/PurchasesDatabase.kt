package com.example.purchases.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Purchase::class],
    version = 1
)
abstract class PurchasesDatabase : RoomDatabase() {

    abstract val dao: PurchaseDao

}