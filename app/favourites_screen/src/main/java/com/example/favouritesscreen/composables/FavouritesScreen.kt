package com.example.favouritesscreen.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.favouritesscreen.FavouritesScreenContract
import kotlinx.coroutines.flow.Flow

@Composable
fun FavouritesScreen(
    state: FavouritesScreenContract.State,
    effectFlow: Flow<FavouritesScreenContract.Effect>?,
    onEventSent: (event: FavouritesScreenContract.Event) -> Unit,
    navigateToCreateTagSheet: () -> Unit
) {

    //LaunchedEffect(Unit) {
    onEventSent(FavouritesScreenContract.Event.RefreshRepositoryValues)
    //}
    var tagsState by remember { mutableStateOf(state.tagsState) }

    //when (state.tagsState) {
    when (tagsState) {
        FavouritesScreenContract.TagsState.NoTags -> FavouritesNoTagsScreen(
            state,
            effectFlow,
            onEventSent,
            navigateToCreateTagSheet
        )

        FavouritesScreenContract.TagsState.FirstTag -> FavouritesFirstTagScreen(
            state,
            effectFlow,
            onEventSent,
            navigateToCreateTagSheet
        )

        FavouritesScreenContract.TagsState.ExistingTags -> FavouritesTagsScreen(
            state,
            effectFlow,
            onEventSent,
            navigateToCreateTagSheet
        )
    }
}