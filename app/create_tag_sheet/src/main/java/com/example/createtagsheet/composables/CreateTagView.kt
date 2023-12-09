package com.example.createtagsheet.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.createtagsheet.CreateTagSheetContract

@Composable
fun CreateTagView(onEventSent: (event: CreateTagSheetContract.Event) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var tagInputText by remember { mutableStateOf("") }

        CreateTagHeader()
        CreateTagInput { value -> tagInputText = value }
        AdditionalHint()
        CreateButton { onEventSent(CreateTagSheetContract.Event.CreateButtonActionClick(tagInputText)) }
    }
}