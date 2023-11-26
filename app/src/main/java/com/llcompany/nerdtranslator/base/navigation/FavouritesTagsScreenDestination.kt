package com.llcompany.nerdtranslator.base.navigation

import androidx.compose.runtime.Composable
import com.example.favouritesscreen.FavouritesScreenViewModel
import com.example.favouritesscreen.composables.FavouritesTagsScreen
import org.koin.androidx.compose.getViewModel

@Composable
fun FavouritesTagsScreenDestination(navigateToCreateTagSheet: () -> Unit) {
    val viewModel = getViewModel<FavouritesScreenViewModel>()
    FavouritesTagsScreen(
        viewModel.getState().value,
        viewModel.currentEffect,
        onEventSent = { event -> viewModel.onEventReceived(event) },
        navigateToCreateTagSheet = navigateToCreateTagSheet
    )
}