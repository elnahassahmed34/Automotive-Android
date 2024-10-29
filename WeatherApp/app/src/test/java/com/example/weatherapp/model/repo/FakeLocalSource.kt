package com.example.weatherapp.model.repo

import com.example.weatherapp.database.LocalSource
import com.example.weatherapp.model.alert.AlertItem
import com.example.weatherapp.model.forecast.Alert
import com.example.weatherapp.model.forecast.ForecastModel
import kotlinx.coroutines.flow.Flow

class FakeLocalSource(
    private val forecastList: Flow<List<ForecastModel>>,
    private val alertsList: Flow<List<AlertItem>>,
    private val forecast: ForecastModel?,
    private var language:Flow<String>,
    private var tempUnit:Flow<String>,
    private var windSpeedUnit:Flow<String>,
    private var notificationFlag:Flow<Boolean>,
) : LocalSource {
    override suspend fun getFavorites(): Flow<List<ForecastModel>> {
        return forecastList
    }



    override suspend fun insertFavorite(forecast: ForecastModel): Long {
        forecastList.collect(forecast)
        return 1L
    }

    override suspend fun deleteFavorites() {
        TODO("Not yet implemented")
    }

//    override suspend fun deleteFavorites() {
//        forecastList.()
//    }

    override suspend fun deleteFavorite(timezone: String) {
        TODO("Not yet implemented")
    }

//    override suspend fun deleteFavorite(forecast: ForecastModel): Int {
//        forecastList.remove(forecast)
//        return 1
//    }

//    override suspend fun deleteCurrent() {
//        forecastList.removeIf { it.isCurrent }
//    }

    override suspend fun getAlerts(): Flow<List<AlertItem>> {
        return alertsList
    }

    override suspend fun insertAlert(alertItem: AlertItem) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAlert(alertId: Int) {
        TODO("Not yet implemented")
    }

//    override suspend fun insertAlert(alertItem: AlertItem): Long {
//        alertsList.add(alertItem)
//        return 1L
//    }
//
//    override suspend fun deleteAlert(alertId: Int) {
//        alertsList.removeIf { it.id == alertId }
//    }

    override suspend fun getLanguage(): Flow<String> {
        return language
    }

    override suspend fun getTempUnit(): Flow<String> {
        return tempUnit
    }

    override suspend fun getWindSpeedUnit(): Flow<String> {
        return windSpeedUnit
    }

    override suspend fun getNotificationFlag(): Flow<Boolean> {
        return notificationFlag
    }

    override suspend fun setLanguage(lang: String) {
        TODO("Not yet implemented")
    }

    override suspend fun setTempUnit(unit: String) {
        TODO("Not yet implemented")
    }

    override suspend fun setWindSpeedUnit(unit: String) {
        TODO("Not yet implemented")
    }

    override suspend fun setNotificationFlag(notifyFlag: Boolean) {
        TODO("Not yet implemented")
    }

//    override suspend fun setLanguage(lang: String) {
//        language = lang
//    }
//
//    override suspend fun setTempUnit(unit: String) {
//        tempUnit = unit
//    }
//
//    override suspend fun setWindSpeedUnit(unit: String) {
//        windSpeedUnit = unit
//    }

//    override suspend fun setNotificationFlag(notifyFlag: Boolean) {
//        notificationFlag = notifyFlag
//    }

    override suspend fun setSelectedForecast(forecast: ForecastModel) {
        TODO("Not yet implemented")
    }

    override suspend fun getSelectedForecast(): Flow<ForecastModel?> {
        TODO("Not yet implemented")
    }
}