package com.haw.forecastapp.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.haw.forecastapp.R

@Composable
fun ItemDrawer() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Divider(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .height(4.dp)
        )
        Row(
            modifier = Modifier.padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = stringResource(R.string.icon_favorite),
                tint = Color.Gray
            )
            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = stringResource(R.string.favorites),
                style = MaterialTheme.typography.h3
            )
        }
        Row(
            modifier = Modifier.padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = stringResource(R.string.icon_favorite),
                tint = Color.Gray
            )
            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = stringResource(R.string.about),
                style = MaterialTheme.typography.h3
            )
        }
        Row(
            modifier = Modifier.padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = stringResource(R.string.icon_favorite),
                tint = Color.Gray
            )
            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = stringResource(R.string.settings),
                style = MaterialTheme.typography.h3
            )
        }
    }
}