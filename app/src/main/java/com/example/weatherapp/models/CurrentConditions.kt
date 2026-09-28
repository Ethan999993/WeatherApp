package com.example.weatherapp.models

data class CurrentConditions(
    val location: String,
    val resourceId: Int,
    val condition: String,
    val temp: String,
    val feelsLike: String,
    val wind: String,
    val humidity: String
)