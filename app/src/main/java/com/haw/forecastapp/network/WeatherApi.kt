package com.haw.forecastapp.network

import com.haw.forecastapp.model.Weather
import com.haw.forecastapp.utils.Constants.API_KEY
import com.haw.forecastapp.utils.Constants.UNITS_APY
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {

    @GET(value = "data/2.5/forecast/daily")
    suspend fun getWeather(
        @Query("q") query: String,
        @Query("units") units: String = UNITS_APY,
        @Query("appid") appid: String = API_KEY
    ): Weather

}