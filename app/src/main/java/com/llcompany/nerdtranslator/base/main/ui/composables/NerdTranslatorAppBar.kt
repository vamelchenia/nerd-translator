package com.llcompany.nerdtranslator.base.main.ui.composables

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.llcompany.nerdtranslator.R

@Composable
fun NerdTranslatorAppBar() {
    CenterAlignedTopAppBar(
        title = { TopAppBarTitle() },
        actions = {
            ActionButtonFavourites()
            ActionButtonSettings()
        }
    )
}

@Composable
fun TopAppBarTitle() {
    Text(
        text = stringResource(R.string.top_app_bar_title),
        style = MaterialTheme.typography.headlineLarge.copy(
            color = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
fun ActionButtonFavourites() {
    IconButton(
        onClick = { /*TODO*/ }
    ) {
        Icon(
            painter = painterResource(R.drawable.icon_favourites),
            contentDescription = stringResource(R.string.favourites_icon_content_desc),
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun ActionButtonSettings() {
    IconButton(
        onClick = { /*TODO*/ }
    ) {
        Icon(
            painter = painterResource(R.drawable.icon_settings),
            contentDescription = stringResource(R.string.favourites_icon_content_desc),
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}
