package com.example.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.model.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class DB_Creator : RoomDatabase() {

    abstract fun favProductDao(): Fav_Product_DB_DAO

    companion object {
        @Volatile
        private var INSTANCE: DB_Creator? = null

        fun getDatabase(context: Context): DB_Creator {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DB_Creator::class.java,
                    "products_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
