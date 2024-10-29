package com.example.weatherapp.model.repo

import com.example.weatherapp.model.forecast.ForecastModel
import com.example.weatherapp.network.RemoteSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class FakeRemoteSource(private val forecast: ForecastModel) : RemoteSource {
    override suspend fun getForecast(
        lat: Double,
        lon: Double,
        lang: String
    ): Flow<Response<ForecastModel>> {
        return Flow<Response.success(forecast)>
    }
}
