package com.haw.forecastapp.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.haw.forecastapp.data.DataOrException
import com.haw.forecastapp.model.Weather

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
            value = mainViewModel.getWeatherData(city = "Moscow")
        }.value

    Text(
        text = "This is Main Screen ${weatherData.data}",
        style = MaterialTheme.typography.h1
    )
    ShowData(mainViewModel)
}

@Composable
fun ShowData(mainViewModel: MainViewModel) {
    val weatherData =
        produceState<DataOrException<Weather, Boolean, Exception>>(
            initialValue =
            DataOrException(loading = true)
        ) {
            value = mainViewModel.getWeatherData(city = "Moscow")
        }.value

    if (weatherData.loading == true) {
        CircularProgressIndicator()
    } else if (weatherData.data != null) {
        Column() {
            Text(
                text = "Main Screen : ${weatherData.data!!}",
                style = MaterialTheme.typography.h1
            )
        }
    }

}