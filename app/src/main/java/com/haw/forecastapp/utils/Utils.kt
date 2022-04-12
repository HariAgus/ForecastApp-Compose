package com.haw.forecastapp.utils

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(timeStamp: Int): String {
    val sdf = SimpleDateFormat("EEE, MMM d")
    val date = Date(timeStamp.toLong() * 1000)
    return sdf.format(date)
}

fun formatDateTime(timeStamp: Int): String {
    val sdf = SimpleDateFormat("hh:mm:aa")
    val date = Date(timeStamp.toLong() * 1000)
    return sdf.format(date)
}

fun formatDecimals(item: Double): String {
    return " %.0f".format(item)
}