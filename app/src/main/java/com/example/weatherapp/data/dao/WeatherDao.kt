package com.example.weatherapp.data.dao


import com.google.gson.annotations.SerializedName

data class Weather (

    val location: Location,
    val current: Current,
    val forecast: Forecast
)

data class Location (
    val name: String,
    val region: String
)

data class Forecast(

    @SerializedName("forecastday") val forecastDay: List<ForecastDay>

)


data class Current (
    @SerializedName("temp_c") val tempCelsius: Float,
    @SerializedName("feelslike_c") val feelsLikeCelsius: Float,
    val condition: Condition,
    @SerializedName("wind_kph") val windKph: Float,
    @SerializedName("wind_degree") val windDegree: Float,

    @SerializedName("wind_dir") val windDirection: String,
    val humidity: String,
    @SerializedName("chance_of_rain") val chanceOfRain: Int,
    @SerializedName("chance_of_snow") val chanceOfSnow: Int,
    @SerializedName("precip_mm") val precipitationMM: Int,


    )

data class Condition (

    val text: String,
    val icon: String

)

data class ForecastDay(
    val date: String,
    val day: Day

)

data class Day(
    @SerializedName("maxtemp_c")val maxTempC: Float,
    @SerializedName("mintemp_c") val minTempC: Float,
    @SerializedName("maxwind_kph") val maxWindSpeed: Float,
    @SerializedName("daily_chance_of_rain") val dailyChanceOfRain: Int,
    @SerializedName("daily_chance_of_snow") val dailyChanceOfSnow: Int,
    @SerializedName("totalsnow_cm") val totalSnowCM: Float,
    @SerializedName("totalprecip_mm") val totalPrecipitationMM: Float,
    @SerializedName("avghumidity") val averageHumidity: Int,


    val condition: Condition,






)

