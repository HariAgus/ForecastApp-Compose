package com.haw.forecastapp.screens

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun MainScreen(
    navController: NavController
) {
    Text(
        text = "Main Screen",
        style = MaterialTheme.typography.h1
    )
}