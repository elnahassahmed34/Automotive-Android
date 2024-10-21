package com.example.weatherapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.weatherapp.model.alert.AlertItem
import com.example.weatherapp.model.forecast.ForecastModel

@Database(entities = [ForecastModel::class,AlertItem::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getFavoritesDao(): FavoritesDao
    abstract fun getAlertsDao(): AlertsDao
    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null
        fun getInstance(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, AppDataBase::class.java, "weather_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}