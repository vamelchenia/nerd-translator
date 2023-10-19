package com.example.createtagsheet.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.createtagsheet.CreateTagSheetViewModel

@Composable
fun CreateTagSheet(createTagSheetViewModel:CreateTagSheetViewModel) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (createTagSheetViewModel.getState().value.isCreated) {
            CreatedTagView(createTagSheetViewModel)
        } else {
            CreateTagView(createTagSheetViewModel)
        }
    }
}