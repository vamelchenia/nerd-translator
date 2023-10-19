package com.llcompany.nerdtranslator.base.navigation

import androidx.compose.runtime.Composable
import com.example.createtagsheet.CreateTagSheetViewModel
import com.example.createtagsheet.composables.CreateTagSheet
import org.koin.androidx.compose.getViewModel

@Composable
fun CreateTagSheetDestination() {
    val createTagSheetViewModel = getViewModel<CreateTagSheetViewModel>()
    CreateTagSheet(createTagSheetViewModel)
}