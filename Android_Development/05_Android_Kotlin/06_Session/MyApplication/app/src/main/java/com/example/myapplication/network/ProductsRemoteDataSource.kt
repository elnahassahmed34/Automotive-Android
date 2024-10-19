package com.example.myapplication.Network

//import ApiState
import com.example.myapplication.model.ProductsResponse
import retrofit2.Response

import kotlinx.coroutines.flow.StateFlow

interface ProductsRemoteDataSource {
    val productsStateFlow: StateFlow<ApiState<ProductsResponse>> // Declare a StateFlow for tracking API state
    suspend fun fetchProducts() // Function to trigger the API call and emit states
}

