package com.example.createtagsheet.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.createtagsheet.CreateTagSheetContract

@Composable
fun TagCreatedView(onEventSent: (event: CreateTagSheetContract.Event) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        TagCreatedHeader()
        AdditionalHint()
        TagCreatedButton { onEventSent(CreateTagSheetContract.Event.TagCreatedButtonActionClick) }
    }
}
