package com.haw.forecastapp.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.haw.forecastapp.R
import com.haw.forecastapp.data.DataOrException
import com.haw.forecastapp.model.Weather
import com.haw.forecastapp.model.WeatherItem
import com.haw.forecastapp.ui.theme.gradientBackgroundPrimary
import com.haw.forecastapp.ui.theme.gray
import com.haw.forecastapp.utils.Constants
import com.haw.forecastapp.utils.formatDate
import com.haw.forecastapp.utils.formatDateTime
import com.haw.forecastapp.utils.formatDecimals
import com.haw.forecastapp.widgets.WeatherAppBar
import java.util.*

@Composable
fun MainScreen(
    navController: NavController,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val weatherData =
        produceState<DataOrException<Weather, Boolean, Exception>>(
            initialValue =
            DataOrException(loading = true)
        ) {
            value = mainViewModel.getWeatherData(city = "Jakarta")
        }.value

    if (weatherData.loading == true) {
        CircularProgressIndicator()
    } else if (weatherData.data != null) {
        MainScaffold(
            weather = weatherData.data!!,
            navController = navController
        )
    }
}

@Composable
fun MainScaffold(
    weather: Weather,
    navController: NavController
) {
    Scaffold(
        topBar = {
            WeatherAppBar(
                title = weather.city.name + ", ${weather.city.country}",
                navController = navController,
            ) {}
        },
        backgroundColor = gray
    ) {
        MainContent(data = weather)
    }
}

@Composable
fun MainContent(data: Weather) {
    val imageUrl = Constants.BASE_IMAGE_URL + data.list[0].weather[0].icon + ".png"
    val weather = data.list[0].weather[0]

    Column(
        Modifier
            .fillMaxWidth()
            .background(color = gray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.padding(6.dp),
            text = formatDate(data.list[0].dt), // Wed Nov 30
            style = MaterialTheme.typography.h2,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .height(IntrinsicSize.Max)
                .background(
                    brush = gradientBackgroundPrimary,
                    shape = RoundedCornerShape(24.dp),
                ),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                WeatherStateImage(imageUrl = imageUrl)
                Text(
                    text = formatDecimals(data.list[0].temp.day) + "°",
                    style = MaterialTheme.typography.h2,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp
                )
                Text(
                    text = weather.main,
                    style = MaterialTheme.typography.h3,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp
                )
                HumidityWindPressureRow(weather = data.list[0])
            }
        }
        SunsetSunRiseRow(weather = data.list[0])
        Divider(
            modifier = Modifier.padding(4.dp),
            thickness = 2.dp
        )
        Text(
            text = stringResource(R.string.weather_this_week),
            style = MaterialTheme.typography.h2,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Surface(
            modifier = Modifier
                .background(color = gray)
                .fillMaxWidth()
                .fillMaxHeight(),
        ) {
            LazyColumn(
                modifier = Modifier
                    .background(color = gray),
                contentPadding = PaddingValues(1.dp)
            ) {
                items(items = data.list) { item ->
                    WeatherDetailRow(weather = item)
                }
            }
        }
    }

}

@Composable
fun HumidityWindPressureRow(weather: WeatherItem) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.humidity),
                contentDescription = stringResource(R.string.humidity_icon),
                modifier = Modifier.size(20.dp)
            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = "${weather.humidity}%",
                style = MaterialTheme.typography.h5
            )
        }
        Row(
            modifier = Modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.pressure),
                contentDescription = stringResource(R.string.pressure_icon),
                modifier = Modifier.size(20.dp)
            )
            Text(
                modifier = Modifier
                    .padding(start = 4.dp)
                    .align(Alignment.CenterVertically),
                text = "${weather.pressure} psi",
                style = MaterialTheme.typography.h5
            )
        }
        Row(
            modifier = Modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.wind),
                contentDescription = stringResource(R.string.wind_icon),
                modifier = Modifier.size(20.dp)
            )
            Text(
                modifier = Modifier
                    .padding(start = 4.dp)
                    .align(Alignment.CenterVertically),
                text = "${weather.humidity} mph",
                style = MaterialTheme.typography.h5
            )
        }
    }
}

@Composable
fun SunsetSunRiseRow(weather: WeatherItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 12.dp,
                bottom = 6.dp,
                start = 16.dp,
                end = 16.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.sunrise),
                contentDescription = stringResource(R.string.sunrise_icon),
                modifier = Modifier.size(32.dp),
            )
            Text(
                modifier = Modifier
                    .padding(end = 4.dp, top = 4.dp)
                    .align(Alignment.CenterVertically),
                text = formatDateTime(weather.sunrise),
                style = MaterialTheme.typography.h6,
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(end = 4.dp, top = 4.dp)
                    .align(Alignment.CenterVertically),
                text = formatDateTime(weather.sunset),
                style = MaterialTheme.typography.h6,
            )
            Image(
                painter = painterResource(id = R.drawable.sunset),
                contentDescription = stringResource(R.string.sunset_icon),
                modifier = Modifier.size(32.dp),
            )
        }
    }
}

@Composable
fun WeatherDetailRow(weather: WeatherItem) {
    val imageUrl = Constants.BASE_IMAGE_URL + weather.weather[0].icon + ".png"

    Surface(
        modifier = Modifier
            .padding(8.dp)
            .height(IntrinsicSize.Max)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        color = Color.White,
        elevation = 6.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(start = 6.dp)
            ) {
                Text(
                    modifier = Modifier.padding(6.dp),
                    text = formatDate(weather.dt),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = weather.weather[0].description.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(
                            Locale.getDefault()
                        ) else it.toString()
                    },
                    fontWeight = FontWeight.SemiBold
                )
            }
            Image(
                modifier = Modifier.size(80.dp),
                painter = rememberImagePainter(imageUrl),
                contentDescription = stringResource(id = R.string.sunrise_icon),
            )
        }
    }

}

@Composable
fun WeatherStateImage(imageUrl: String) {
    Image(
        painter = rememberImagePainter(imageUrl),
        contentDescription = stringResource(R.string.icon_image),
        modifier = Modifier.size(100.dp)
    )
}




