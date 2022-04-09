package com.haw.forecastapp.screens.main

import androidx.lifecycle.ViewModel
import com.haw.forecastapp.data.DataOrException
import com.haw.forecastapp.model.Weather
import com.haw.forecastapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    suspend fun getWeatherData(
        city: String
    ): DataOrException<Weather, Boolean, Exception> {
        return repository.getWeather(city = city)
    }

}