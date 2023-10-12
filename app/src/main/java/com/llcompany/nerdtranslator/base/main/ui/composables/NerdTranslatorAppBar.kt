package com.llcompany.nerdtranslator.base.main.ui.composables

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.llcompany.nerdtranslator.R
import com.llcompany.nerdtranslator.base.main.TopAppBarContract
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun NerdTranslatorAppBar(
    state: TopAppBarContract.State,
    effectFlow: Flow<TopAppBarContract.Effect>?,
    onEventSent: (event: TopAppBarContract.Event) -> Unit,
    navigateToFavouries: () -> Unit,
    navigateToSettings: () -> Unit,
) {
    LaunchedEffect(true) {
        effectFlow?.onEach { effect ->
            when (effect) {
                is TopAppBarContract.Effect.Navigation.ToFavourites -> {
                    navigateToFavouries()
                }

                is TopAppBarContract.Effect.Navigation.ToSettings -> {
                    navigateToSettings()
                }
            }
        }?.collect()
    }

    CenterAlignedTopAppBar(
        title = { TopAppBarTitle() },
        actions = {
            ActionButtonFavourites {
                onEventSent(TopAppBarContract.Event.FavouritesActionClick)
            }
            ActionButtonSettings {
                onEventSent(TopAppBarContract.Event.SettingsActionClick)
            }
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
fun ActionButtonFavourites(onClickAction: () -> Unit) {
    IconButton(
        onClick = { onClickAction() }
    ) {
        Icon(
            painter = painterResource(R.drawable.icon_favourites),
            contentDescription = stringResource(R.string.favourites_icon_content_desc),
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun ActionButtonSettings(onClickAction: () -> Unit) {
    IconButton(
        onClick = { onClickAction() }
    ) {
        Icon(
            painter = painterResource(R.drawable.icon_settings),
            contentDescription = stringResource(R.string.favourites_icon_content_desc),
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}
