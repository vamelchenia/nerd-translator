package com.llcompany.nerdtranslator.base.navigation

import androidx.compose.runtime.Composable
import com.example.createtagsheet.CreateTagSheetViewModel
import com.example.createtagsheet.composables.CreateTagSheet
import org.koin.androidx.compose.getViewModel

@Composable
fun CreateTagSheetDestination(
    createNewTag: () -> Unit,
    tagCreated: () -> Unit,
) {
    val viewModel = getViewModel<CreateTagSheetViewModel>()
    CreateTagSheet(
        viewModel.getState().value,
        viewModel.currentEffect,
        onEventSent = { event -> viewModel.onEventReceived(event) },
        createNewTag = createNewTag,
        tagCreated = tagCreated
    )
}