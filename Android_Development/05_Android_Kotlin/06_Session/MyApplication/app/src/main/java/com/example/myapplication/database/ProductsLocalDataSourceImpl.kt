package com.example.myapplication.database

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.myapplication.model.Product
import kotlinx.coroutines.flow.Flow

class ProductsLocalDataSourceImpl(
    private val dao: Fav_Product_DB_DAO
) : ProductsLocalDataSource {

    override suspend fun addProduct(product: Product) {
        Log.i("TAG", "nahass getFavoriteProducts:2 ")
        dao.insertProduct(product)
    }

    override suspend fun removeProduct(product: Product) {
        dao.deleteProduct(product)
    }

    override fun getFavoriteProducts(): Flow<List<Product>> {
        return dao.getAllFavProducts()  // Now returning Flow
    }

    override suspend fun getProductById(id: Int): Product? {
        return dao.getProductById(id)
    }
}
