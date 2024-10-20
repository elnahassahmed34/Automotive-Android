package com.example.myapplication.model

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ProductsRepository {
    suspend fun getAllProducts(): Flow<List<Product>>
    fun getFavoriteProducts(): Flow<List<Product>>
    suspend fun addProductToFavorites(product: Product)
    suspend fun removeProductFromFavorites(product: Product)
}
