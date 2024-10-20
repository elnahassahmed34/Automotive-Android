package com.example.myapplication.Network

import com.example.myapplication.model.Product
import com.example.myapplication.model.ProductsResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ProductsRemoteDataSource {
    suspend fun fetchProducts(): ProductsResponse
}
