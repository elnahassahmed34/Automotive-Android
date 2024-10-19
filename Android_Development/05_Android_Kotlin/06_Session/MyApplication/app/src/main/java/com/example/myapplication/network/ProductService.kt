package com.example.myapplication.Network

import com.example.myapplication.model.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    suspend fun getProducts(): Response<ProductsResponse>

}
