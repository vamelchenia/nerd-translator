package com.example.createtagsheet.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.createtagsheet.CreateTagSheetContract
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun CreateTagSheet(
    state: CreateTagSheetContract.State,
    effectFlow: Flow<CreateTagSheetContract.Effect>?,
    onEventSent: (event: CreateTagSheetContract.Event) -> Unit,
    createNewTag: () -> Unit,
    tagCreated: () -> Unit,
) {
    LaunchedEffect(true) {
        effectFlow?.onEach { effect ->
            when (effect) {
                is CreateTagSheetContract.Effect.Navigation.CreateTag -> {
                    createNewTag()
                }

                is CreateTagSheetContract.Effect.Navigation.TagCreated -> {
                    tagCreated()
                }
            }
        }?.collect()
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (state.isCreated) {
            TagCreatedView(onEventSent = onEventSent)
        } else {
            CreateTagView(onEventSent = onEventSent)
        }
    }
}
