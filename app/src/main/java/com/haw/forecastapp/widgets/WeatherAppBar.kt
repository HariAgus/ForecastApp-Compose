package com.haw.forecastapp.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.haw.forecastapp.R

@Composable
fun WeatherAppBar(
    title: String = "Jakarta, Indonesia",
    icon: ImageVector? = null,
    isMainScreen: Boolean = true,
    elevation: Dp = 0.dp,
    navController: NavController,
    onAddActionClicked: () -> Unit = {},
    onButtonClicked: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = MaterialTheme.colors.onSecondary,
                style = MaterialTheme.typography.h5
            )
        },
        actions = {
            if (isMainScreen) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(R.string.search_icon)
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = stringResource(R.string.search_icon)
                    )
                }
            } else {
                Box {

                }
            }
        },
        navigationIcon = {
            if (icon != null) {
                Icon(
                    modifier = Modifier.clickable {
                        onButtonClicked.invoke()
                    },
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colors.onSecondary
                )
            }
        },
        backgroundColor = Color.Transparent,
        elevation = elevation
    )
}


