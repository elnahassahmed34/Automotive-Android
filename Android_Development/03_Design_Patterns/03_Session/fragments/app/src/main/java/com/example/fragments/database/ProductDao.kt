package com.example.fragments.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fragments.model.Product


@Dao
interface ProductDao {
    @Query("SELECT * FROM product_table")
    fun getAllProducts(): List<Product>

    @Insert
    suspend fun insertAll(products: List<Product>)

    @Query("DELETE FROM product_table")
    suspend fun deleteAll()
}