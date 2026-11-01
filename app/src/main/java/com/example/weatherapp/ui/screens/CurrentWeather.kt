package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.weatherapp.MainViewModel
import com.example.weatherapp.R
import com.example.weatherapp.data.dao.Location
import kotlin.math.roundToInt


@Composable
fun CurrentWeather(viewModel: MainViewModel) {

    val weather = viewModel.weather

    viewModel.getWeather("Windsor Nova Scotia ")

    weather?.let {

        val imageUrl = "https:" + weather.current.condition.icon.replace("64x64", "128x128")

        val precipitationChance = maxOf(
            weather.current.chanceOfRain,
            weather.current.chanceOfSnow
        )

        val precipitationText: String

        if (precipitationChance == 0) {
            precipitationText = "No precipitation expected"
        }
        else if (weather.current.chanceOfSnow > weather.current.chanceOfRain) {
            precipitationText = "Chance of Snow: $precipitationChance%"
        }
        else {
            precipitationText = "Chance of Rain: $precipitationChance%"
        }





        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        )
            {
            AsyncImage(

                model = imageUrl,
                contentDescription = "Weather condition",
                modifier = Modifier.size(128.dp)
            )

                Text(
                    text = "Location: ${weather.location.name}, ${weather.location.region} "
                )
                Text(
                    text = "Condition: ${weather.current.condition.text}"
                )
                Text(
                    text = "Temperature : ${weather.current.tempCelsius.roundToInt()}°C"
                )
                Text(
                    text = "Feels Like : ${weather.current.feelsLikeCelsius.roundToInt()}°C"
                )
                Text(
                    text = "Wind Speed and Direction: ${weather.current.windKph.roundToInt()} km/h ${weather.current.windDegree}° ${weather.current.windDirection},"
                )

                Text(
                    text = precipitationText
                )
                if (precipitationChance > 0) {
                    Text(
                        text = "Precipitation: ${weather.current.precipitationMM} mm"
                    )
                }

                Text(
                    text = "Humidity: ${weather.current.humidity}%"
                )

        }

        }
    }

