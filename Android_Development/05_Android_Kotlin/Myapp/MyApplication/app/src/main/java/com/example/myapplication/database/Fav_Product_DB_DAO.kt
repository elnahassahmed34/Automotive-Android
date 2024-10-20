package com.example.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface Fav_Product_DB_DAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)

    @Query("SELECT * FROM product_table")
    fun getAllFavProducts(): Flow<List<Product>>

    @Query("SELECT * FROM product_table WHERE id = :id LIMIT 1")
    suspend fun getProductById(id: Int): Product?
}
