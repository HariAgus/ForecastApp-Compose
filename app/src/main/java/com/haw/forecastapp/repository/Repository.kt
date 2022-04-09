package com.haw.forecastapp.repository

import android.util.Log
import com.haw.forecastapp.data.DataOrException
import com.haw.forecastapp.model.Weather
import com.haw.forecastapp.model.WeatherObject
import com.haw.forecastapp.network.WeatherApi
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: WeatherApi
) {

    suspend fun getWeather(
        city: String
    ): DataOrException<Weather, Boolean, Exception> {
        val response = try {
            api.getWeather(query = city)
        } catch (e: Exception) {
            return DataOrException(e = e)
        }
        return DataOrException(data = response)
    }

}