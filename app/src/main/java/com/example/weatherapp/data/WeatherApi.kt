package com.example.weatherapp.data

import com.example.weatherapp.data.dao.Weather
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {

    @GET("v1/forecast.json")
    suspend fun getWeather(
        @Query("key") key: String = "d9e2bdaae03749148f8180232261910",
        @Query("q") q: String,
        @Query("days") days: String = "3",
        @Query("aqi") aqi: String = "no",
        @Query("alerts") alerts: String ="no",

    ): Weather
}