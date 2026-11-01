package com.example.weatherapp

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.dao.Weather
import com.example.weatherapp.data.WeatherApi
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

   var weather by mutableStateOf<Weather?>(value=null)
    private set


    private val api = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WeatherApi::class.java)

    fun getWeather(query: String) {
        viewModelScope.launch {
            weather = api.getWeather(q=query)
        }

    }
}





