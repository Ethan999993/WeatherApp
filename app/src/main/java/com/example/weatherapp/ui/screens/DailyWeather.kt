


package com.example.weatherapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.weatherapp.MainViewModel
import kotlin.math.roundToInt

@Composable
fun DailyWeather(viewModel: MainViewModel) {

    val weather = viewModel.weather

    viewModel.getWeather("Windsor Nova Scotia")

    weather?.let { currentWeather ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            item {



                Text(
                    text = "Location: ${currentWeather.location.name}, ${currentWeather.location.region}"
                )

                Spacer(modifier = Modifier.height(12.dp))
            }

            items(currentWeather.forecast.forecastDay) { forecast ->

                val imageUrl = "https:" +
                        forecast.day.condition.icon.replace("64x64", "128x128")

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    HorizontalDivider()

                    Text(
                        text = forecast.date,
                        style = MaterialTheme.typography.titleLarge
                    )

                    AsyncImage(
                        model = imageUrl,
                        contentDescription = forecast.day.condition.text,
                        modifier = Modifier.size(128.dp)
                    )

                    Text(
                        text = "Condition: ${forecast.day.condition.text}"
                    )

                    Text(
                        text = "Maximum Temperature: ${forecast.day.maxTempC.roundToInt()}°C"
                    )

                    Text(
                        text = "Minimum Temperature: ${forecast.day.minTempC.roundToInt()}°C"
                    )

                    Text(
                        text = "Maximum Wind Speed: ${forecast.day.maxWindSpeed.roundToInt()} km/h"
                    )

                    Text(
                        text = "Average Humidity: ${forecast.day.averageHumidity}%"
                    )

                    val precipitationChance = maxOf(
                        forecast.day.dailyChanceOfRain,
                        forecast.day.dailyChanceOfSnow
                    )

                    if (precipitationChance == 0) {

                        Text(
                            text = "No precipitation expected"
                        )

                    } else if (forecast.day.dailyChanceOfSnow >
                        forecast.day.dailyChanceOfRain) {

                        Text(
                            text = "Chance of Snow: $precipitationChance%"
                        )

                    } else {

                        Text(
                            text = "Chance of Rain: $precipitationChance%"
                        )
                    }

                    if (forecast.day.totalPrecipitationMM > 0) {

                        Text(
                            text = "Total Precipitation: ${forecast.day.totalPrecipitationMM.roundToInt()} mm"
                        )
                    }

                    if (forecast.day.totalSnowCM > 0) {

                        Text(
                            text = "Total Snow: ${forecast.day.totalSnowCM} cm"
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}
