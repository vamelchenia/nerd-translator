package com.example.favouritesscreen.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.favouritesscreen.FavouritesScreenContract
import kotlinx.coroutines.flow.Flow

@Composable
fun FavouritesScreen(
    state: FavouritesScreenContract.State,
    effectFlow: Flow<FavouritesScreenContract.Effect>?,
    onEventSent: (event: FavouritesScreenContract.Event) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        FavouritesScreenImage()
        CreateButton()
    }
}