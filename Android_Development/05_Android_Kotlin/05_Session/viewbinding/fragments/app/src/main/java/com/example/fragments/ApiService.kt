package com.example.fragments


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



interface ApiService {
    @GET("products")
    fun getProducts(): Call<ProductsResponse>
}


object RetrofitClient {
    private const val BASE_URL = "https://dummyjson.com/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
