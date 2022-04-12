package com.haw.forecastapp.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.haw.forecastapp.R
import com.haw.forecastapp.model.WeatherItem
import com.haw.forecastapp.utils.Constants
import com.haw.forecastapp.utils.formatDate
import java.util.*

@Composable
fun WeatherWeeklyRow(weather: WeatherItem) {
    val imageUrl = Constants.BASE_IMAGE_URL + weather.weather[0].icon + ".png"

    Surface(
        modifier = Modifier
            .padding(8.dp)
            .height(IntrinsicSize.Max)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        color = Color.White,
        elevation = 6.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(start = 6.dp)
            ) {
                Text(
                    modifier = Modifier.padding(6.dp),
                    text = formatDate(weather.dt),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = weather.weather[0].description.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(
                            Locale.getDefault()
                        ) else it.toString()
                    },
                    fontWeight = FontWeight.SemiBold
                )
            }
            Image(
                modifier = Modifier.size(80.dp),
                painter = rememberImagePainter(imageUrl),
                contentDescription = stringResource(id = R.string.sunrise_icon),
            )
        }
    }

}