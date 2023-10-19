package com.llcompany.nerdtranslator.base.navigation

import androidx.compose.runtime.Composable
import com.example.createtagsheet.CreateTagSheetViewModel
import com.example.favouritesscreen.FavouritesScreenViewModel
import com.example.favouritesscreen.composables.FavouritesScreen
import org.koin.androidx.compose.getViewModel

@Composable
fun FavouritesScreenDestination() {
    val viewModel = getViewModel<FavouritesScreenViewModel>()
    val createTagSheetViewModel = getViewModel<CreateTagSheetViewModel>()
    FavouritesScreen(
        viewModel.getState().value,
        viewModel.currentEffect,
        onEventSent = { event -> viewModel.onEventReceived(event) },
        createTagSheetViewModel
    )
}