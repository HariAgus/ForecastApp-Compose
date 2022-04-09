package com.haw.forecastapp.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.haw.forecastapp.R
import com.haw.forecastapp.navigation.WeatherScreens
import com.haw.forecastapp.ui.theme.gradientBackgroundPrimary
import kotlinx.coroutines.delay

@Composable
fun WeatherSplashScreen(
    navController: NavController
) {
    val scale = remember { Animatable(0f) }

    LaunchedEffect(key1 = true, block = {
        scale.animateTo(targetValue = 0.9f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(8f)
                        .getInterpolation(it)
                }
            )
        )
        delay(2000L)
        navController.navigate(WeatherScreens.MainScreen.name)
    })

    SplashScreenContent(scale = scale.value)
}

@Composable
fun SplashScreenContent(scale: Float) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradientBackgroundPrimary)
            .scale(scale = scale),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp),
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(R.string.image_logo),
        )
        
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreenContent(scale = 0f)
}

