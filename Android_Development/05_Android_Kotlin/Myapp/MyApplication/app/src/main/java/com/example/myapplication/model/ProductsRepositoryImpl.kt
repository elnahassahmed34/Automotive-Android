package com.example.myapplication.model

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.myapplication.database.ProductsLocalDataSource
import com.example.myapplication.Network.ProductsRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class ProductsRepositoryImpl(
    private val localDataSource: ProductsLocalDataSource,
    private val remoteDataSource: ProductsRemoteDataSource
) : ProductsRepository {

    override suspend fun getAllProducts(): Flow<List<Product>> = flow {
        // Fetch data from the remote source (network)
        Log.i("TAG", "nahass repository: ")

        val result =  remoteDataSource.fetchProducts()
        emit(result.products)
    }

    override fun getFavoriteProducts(): Flow<List<Product>> {
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
