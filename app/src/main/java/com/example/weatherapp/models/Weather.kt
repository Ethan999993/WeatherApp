package com.example.weatherapp.models

data class Weather(
    val date: String,
    val resourceId: Int,
    val weather: String,
    val high: String,
    val low: String,
    val chance: String,
    val amount: String,
    val wind: String,
    val humidity: String
)