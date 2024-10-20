package com.example.myapplication.Network

import com.example.myapplication.model.Product
import com.example.myapplication.model.ProductsResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    suspend fun getProducts(): ProductsResponse
}
