package com.example.myapplication.network

import android.util.Log
import com.example.myapplication.Network.ProductService
import com.example.myapplication.Network.ProductsRemoteDataSource
import com.example.myapplication.Network.RetrofitHelper
import com.example.myapplication.model.Product
import com.example.myapplication.model.ProductsResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import retrofit2.Response

class ProductsRemoteDataSourceImpl : ProductsRemoteDataSource {

    private val productService: ProductService = RetrofitHelper.getInstance().create(ProductService::class.java)

    override suspend fun fetchProducts(): ProductsResponse {
        try {
            // Make the API call using Retrofit
            Log.i("TAG", "nahass netwo ")
            return productService.getProducts()
            Log.i("TAG", "nahass network ")

        } catch (e: HttpException) {
            throw Exception("Network call failed")
        }
    }
}
