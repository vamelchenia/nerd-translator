package com.llcompany.nerdtranslator.base.navigation

import androidx.compose.runtime.Composable
import com.example.createtagsheet.CreateTagSheetViewModel
import com.example.createtagsheet.composables.CreateTagSheet
import org.koin.androidx.compose.getViewModel

@Composable
fun CreateTagSheetDestination(
    navigateToFavourites: () -> Unit,
    navigateToCreatedTagSheet: () -> Unit,
    tagCreated: Boolean,
) {
    val viewModel = getViewModel<CreateTagSheetViewModel>()
    CreateTagSheet(
        viewModel.getState().value,
        viewModel.currentEffect,
        onEventSent = { event -> viewModel.onEventReceived(event) },
        navigateToFavourites = navigateToFavourites,
        navigateToCreatedTagSheet = navigateToCreatedTagSheet,
        tagCreated = tagCreated,
    )
}