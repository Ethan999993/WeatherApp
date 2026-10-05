package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.models.Weather



@Composable
fun DailyWeather(){

    val weatherList = listOf(
        Weather(
            date=" Mon Sept 28",
            resourceId = R.drawable.rainy,
            weather = "Rain",
            low = "low = 12°C",
            high = "high = 16°C",
            chance = "Chance = 85%",
            amount = "Amount = 18.0mm",
            wind = "Wind = 30 km/h",
            humidity = "Humidity = 87%",),
        Weather(
            date=" Tue Sept 29",
            resourceId = R.drawable.rainy,
            weather = "Rain",
            low = "low = 15°C",
            high = "high = 19°C",
            chance = "Chance = 80%",
            amount = "Amount = 9.0mm",
            wind = "Wind = 23 km/h",
            humidity = "Humidity = 95%"),
        Weather(
            date=" Wed Sept 30",
            resourceId = R.drawable.rainy,
            weather = "Rain",
            low = "low = 15°C",
            high = "high = 18°C",
            chance = "Chance = 50%",
            amount = "Amount = 2.0mm",
            wind = "Wind = 8km/h",
            humidity = "Humidity = 94%"),
        Weather(
            date="Thu Oct 1",
            resourceId = R.drawable.cloud,
            weather = "Cloudy",
            low = "low = 14°C",
            high = "high = 20°C",
            chance = "",
            amount = "",
            wind = "Wind = 19 km/h",
            humidity = "Humidity = 87%"),
        Weather(
            date="Fri Oct 2",
            resourceId = R.drawable.cloud,
            weather = "Cloudy",
            low = "low = 15°C",
            high = "high = 21°C",
            chance = "",
            amount = "",
            wind = "Wind = 19 km/h",
            humidity = "Humidity = 89%"),
        Weather(
            date="Sat Oct 3",
            resourceId = R.drawable.rainy,
            weather = "Rain",
            low = "low = 11°C",
            high = "high = 18°C",
            chance = "Chance = 60%",
            amount = "Amount = 17.0mm",
            wind = "Wind = 13 km/h",
            humidity = "Humidity = 74%"),
        Weather(
            date="Sun Oct 4",
            resourceId = R.drawable.sunny,
            weather = "Sunny",
            low = "low = 9°C",
            high = "high = 15°C",
            chance = "",
            amount = "",
            wind = "Wind = 15 km/h",
            humidity = "Humidity = 71%"),

        )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Halifax, Nova Scotia",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)

        )

        LazyColumn {
            items(weatherList) { weather ->

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = weather.date,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Image(
                        painter = painterResource(id = weather.resourceId),
                        contentDescription = weather.weather,
                        modifier = Modifier.size(100.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = weather.weather,
                        fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))


                    Text(
                        text = weather.high,
                        fontSize = 16.sp
                    )

                    Text(
                        text = weather.low,
                        fontSize = 16.sp
                    )

                    if (weather.chance.isNotBlank()) {
                        Text(
                            text = weather.chance,
                            fontSize = 16.sp
                        )
                    }
                    if (weather.amount.isNotBlank()) {
                        Text(
                            text = weather.amount,
                            fontSize = 16.sp
                        )
                    }

                    Text(
                        text = weather.wind,
                        fontSize = 16.sp
                    )
                    Text(
                        text = weather.humidity,
                        fontSize = 16.sp
                    )
                }

                HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)

            }
        }
    }
}