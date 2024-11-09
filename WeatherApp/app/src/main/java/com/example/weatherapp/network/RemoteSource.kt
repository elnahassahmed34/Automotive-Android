package com.example.weatherapp.network

import com.example.weatherapp.model.forecast.ForecastModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response


interface RemoteSource {
    suspend fun getForecast(lat:Double = 44.4,lon:Double = 45.6,lang:String = "en"): Flow<Response<ForecastModel>>
}