package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class Product(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val imageUrl: String?
)
