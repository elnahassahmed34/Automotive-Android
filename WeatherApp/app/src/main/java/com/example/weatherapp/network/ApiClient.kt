package com.example.weatherapp.network


import com.example.weatherapp.utils.Constants
import kotlinx.coroutines.flow.flow
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient : RemoteSource {
    private fun provideOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val original: Request = chain.request()
            val originalHttpUrl: HttpUrl = original.url()
            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("appid", Constants.API_KEY)
                .addQueryParameter("units", Constants.UNITS)
                .build()
            val requestBuilder: Request.Builder = original.newBuilder()
                .url(url)
            val request: Request = requestBuilder.build()
            chain.proceed(request)
        }
        return httpClient.build()
    }

    private val apiServices = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(provideOkHttpClient())
        .baseUrl(Constants.URL)
        .build().create(ApiServices::class.java)


    override suspend fun getForecast(lat: Double, lon: Double, lang: String) =
        if (lang == Constants.Languages.ARABIC) {
            flow { emit(apiServices.getForecast(lat, lon, "ar")) }
        } else {
            flow { emit(apiServices.getForecast(lat, lon, "en")) }
        }
}