package com.haw.forecastapp.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val gray = Color(0xFFE9E9E9)

val colorPrimary = Color(0xFF3C6FD1)
val colorSecond = Color(0xFF7CA9FF)

val gradientBackgroundPrimary = Brush.linearGradient(
    colors = listOf(
        colorPrimary,
        colorSecond
    )
)

val gradientBackgroundGray = Brush.linearGradient(
    colors = listOf(
        Color.White,
        Color.White.copy(alpha = 0f)
    )
)