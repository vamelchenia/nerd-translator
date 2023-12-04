package com.example.favouritesscreen.composables

import androidx.compose.runtime.Composable
import com.example.favouritesscreen.FavouritesScreenContract
import kotlinx.coroutines.flow.Flow

@Composable
fun FavouritesScreen(
    state: FavouritesScreenContract.State,
    effectFlow: Flow<FavouritesScreenContract.Effect>?,
    onEventSent: (event: FavouritesScreenContract.Event) -> Unit,
    navigateToCreateTagSheet: () -> Unit
) {

    onEventSent(FavouritesScreenContract.Event.RefreshRepositoryValues)

    when (state.tagsNumber) {
        0 -> FavouritesNoTagsScreen(
            state,
            effectFlow,
            onEventSent,
            navigateToCreateTagSheet
        )

        1 -> FavouritesFirstTagScreen(
            state,
            effectFlow,
            onEventSent,
            navigateToCreateTagSheet
        )

        else -> FavouritesTagsScreen(
            state,
            effectFlow,
            onEventSent,
            navigateToCreateTagSheet
        )
    }
}