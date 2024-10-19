package com.example.myapplication.model

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.myapplication.Network.ApiState
import com.example.myapplication.database.ProductsLocalDataSource
import com.example.myapplication.Network.ProductsRemoteDataSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import kotlinx.coroutines.flow.first




class ProductsRepositoryImpl(
    private val localDataSource: ProductsLocalDataSource,
    private val remoteDataSource: ProductsRemoteDataSource
) : ProductsRepository {


    override suspend fun getAllProducts(): ProductsResponse? {
        // Fetch data from the remote source and get the latest emission from StateFlow
        remoteDataSource.fetchProducts() // This triggers the network call

        // Collect the first emitted value from the StateFlow
        val state = remoteDataSource.productsStateFlow.first()

        return when (state) {
            is ApiState.Success -> state.data // Return the products data if successful
            is ApiState.Error -> {
                // Handle the error, log or throw an exception based on your needs
                throw Exception(state.message)
            }
            else -> {
                // Handle loading or other states if necessary
                null
            }
        }
    }


    override   fun getFavoriteProducts(): Flow<List<Product>> {
        Log.i("TAG", "nahass getFavoriteProducts: ")
        // Retrieve favorite products from the local database
        return localDataSource.getFavoriteProducts()
    }

    override suspend fun addProductToFavorites(product: Product) {
        // Add a product to the local favorites (Room database)
        localDataSource.addProduct(product)
    }

    override suspend fun removeProductFromFavorites(product: Product) {
        // Remove a product from the local favorites
        localDataSource.removeProduct(product)
    }
}
