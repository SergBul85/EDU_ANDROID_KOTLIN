package com.example.purchases.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Purchase(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val description: String,

    val amount: Float,

    val date: Long

)
