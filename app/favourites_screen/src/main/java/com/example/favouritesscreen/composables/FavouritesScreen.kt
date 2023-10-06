package com.example.favouritesscreen.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.favouritesscreen.FavouritesScreenContract
import kotlinx.coroutines.flow.Flow

@Composable
fun FavouritesScreen(
    state: FavouritesScreenContract.State,
    effectFlow: Flow<FavouritesScreenContract.Effect>?,
    onEventSent: (event: FavouritesScreenContract.Event) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FavouritesScreenImage()
        CreateButton(state = state.buttonState)
    }
}