package com.example.favouritesscreen.composables

import androidx.compose.runtime.Composable
import com.example.favouritesscreen.FavouritesScreenContract
import kotlinx.coroutines.flow.Flow

@Composable
fun FavouritesScreen(
    state: FavouritesScreenContract.State,
    effectFlow: Flow<FavouritesScreenContract.Effect>?,
    onEventSent: (event: FavouritesScreenContract.Event) -> Unit,
    navigateToNoTagsScreen: () -> Unit,
    navigateToFirstTagScreen: () -> Unit,
    navigateToTagsScreen: () -> Unit,
) {
    when (state.tagCount) {
        0 -> navigateToNoTagsScreen()
        1 -> navigateToFirstTagScreen()
        else -> navigateToTagsScreen()
    }
}