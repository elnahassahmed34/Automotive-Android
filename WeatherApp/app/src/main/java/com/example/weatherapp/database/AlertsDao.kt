package com.example.weatherapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.weatherapp.model.alert.AlertItem
import com.example.weatherapp.model.forecast.ForecastModel

@Dao
interface AlertsDao {
    @Query("SELECT * FROM alert_table")
    fun getAlerts(): List<AlertItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlert(alertItem: AlertItem)

    @Query("DELETE FROM alert_table Where id = :alertId")
    suspend fun deleteAlert(alertId: Int)
}