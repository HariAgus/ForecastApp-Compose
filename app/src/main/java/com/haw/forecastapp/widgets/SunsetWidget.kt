package com.haw.forecastapp.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.haw.forecastapp.R
import com.haw.forecastapp.model.WeatherItem
import com.haw.forecastapp.utils.formatDateTime

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