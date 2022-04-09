package com.haw.forecastapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.haw.forecastapp.navigation.Navigation
import com.haw.forecastapp.ui.theme.ForecastAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForecastAppTheme {
                Navigation()
            }
        }
    }
}