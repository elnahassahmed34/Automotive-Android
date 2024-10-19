package com.example.fragments.network


import com.example.fragments.model.ProductsResponse
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



interface ApiService {
    @GET("products")
    suspend fun getProducts(): ProductsResponse
}


object RetrofitClient {
    private const val BASE_URL = "https://dummyjson.com/"
    private val retrofitInstance = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val service = retrofitInstance.create(ApiService::class.java)
}
