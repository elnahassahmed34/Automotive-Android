package com.example.weatherapp.network

import com.example.weatherapp.model.forecast.ForecastModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface RemoteSource {
    suspend fun getForecast(lat:Double,lon:Double,lang:String): Flow<Response<ForecastModel>>
}