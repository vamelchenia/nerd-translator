package com.llcompany.nerdtranslator.base.navigation

import androidx.compose.runtime.Composable
import com.example.favouritesscreen.FavouritesScreenViewModel
import com.example.favouritesscreen.composables.FavouritesNoTagsScreen
import org.koin.androidx.compose.getViewModel

@Composable
fun FavouritesNoTagsScreenDestination(navigateToCreateTagSheet: () -> Unit) {
    val viewModel = getViewModel<FavouritesScreenViewModel>()
    FavouritesNoTagsScreen(
        viewModel.getState().value,
        viewModel.currentEffect,
        onEventSent = { event -> viewModel.onEventReceived(event) },
        navigateToCreateTagSheet = navigateToCreateTagSheet
    )
}