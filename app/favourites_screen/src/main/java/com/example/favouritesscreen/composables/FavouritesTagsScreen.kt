package com.example.favouritesscreen.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.favouritesscreen.FavouritesScreenContract
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import com.example.favouritesscreen.R

private val layoutMargins = PaddingValues(top = 36.dp)

@Composable
fun FavouritesTagsScreen(
    state: FavouritesScreenContract.State,
    effectFlow: Flow<FavouritesScreenContract.Effect>?,
    onEventSent: (event: FavouritesScreenContract.Event) -> Unit,
    navigateToCreateTagSheet: () -> Unit,
) {
    LaunchedEffect(true) {
        effectFlow?.onEach { effect ->
            when (effect) {
                is FavouritesScreenContract.Effect.Navigation.ToCreateTagSheet -> {
                    navigateToCreateTagSheet()
                }
            }
        }?.collect()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        TagList(state)
        ConstraintLayout(
            modifier = Modifier
                .padding(layoutMargins)
        ) {
            CreateTag(stringResource(R.string.create_new_tag_button_name))
            { onEventSent(FavouritesScreenContract.Event.CreateTagActionClick) }
        }
    }
}