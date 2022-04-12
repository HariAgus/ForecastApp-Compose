package com.haw.forecastapp.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
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

@Composable
fun HumidityRow(weather: WeatherItem) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.humidity),
                contentDescription = stringResource(R.string.humidity_icon),
                modifier = Modifier.size(20.dp)
            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = "${weather.humidity}%",
                style = MaterialTheme.typography.h5
            )
        }
        Row(
            modifier = Modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.pressure),
                contentDescription = stringResource(R.string.pressure_icon),
                modifier = Modifier.size(20.dp)
            )
            Text(
                modifier = Modifier
                    .padding(start = 4.dp)
                    .align(Alignment.CenterVertically),
                text = "${weather.pressure} psi",
                style = MaterialTheme.typography.h5
            )
        }
        Row(
            modifier = Modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.wind),
                contentDescription = stringResource(R.string.wind_icon),
                modifier = Modifier.size(20.dp)
            )
            Text(
                modifier = Modifier
                    .padding(start = 4.dp)
                    .align(Alignment.CenterVertically),
                text = "${weather.humidity} mph",
                style = MaterialTheme.typography.h5
            )
        }
    }
}