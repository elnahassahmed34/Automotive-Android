package com.example.myapplication.database

import androidx.lifecycle.LiveData
import com.example.myapplication.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsLocalDataSource {
    suspend fun addProduct(product: Product)
    suspend fun removeProduct(product: Product)
    fun getFavoriteProducts(): Flow<List<Product>>
    suspend fun getProductById(id: Int): Product?
}
