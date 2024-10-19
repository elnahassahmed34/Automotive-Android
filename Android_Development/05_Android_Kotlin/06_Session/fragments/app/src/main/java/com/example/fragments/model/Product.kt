package com.example.fragments.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class ProductsResponse(val products: List<Product>)

@Entity(tableName = "product_table")
data class Product(
    @PrimaryKey val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val thumbnail: String
)
