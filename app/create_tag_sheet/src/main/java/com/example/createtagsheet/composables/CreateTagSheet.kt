package com.example.createtagsheet.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.createtagsheet.CreateTagSheetContract
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

private val bottomSheetMargins = PaddingValues(top = 70.dp)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTagSheet(
    state: CreateTagSheetContract.State,
    effectFlow: Flow<CreateTagSheetContract.Effect>?,
    onEventSent: (event: CreateTagSheetContract.Event) -> Unit,
    navigateToFavourites: () -> Unit,
    navigateToCreatedTagSheet: () -> Unit,
    tagCreated: Boolean,
) {

    val sheetState = rememberModalBottomSheetState(true)

    LaunchedEffect(true) {
        effectFlow?.onEach { effect ->
            when (effect) {
                is CreateTagSheetContract.Effect.Navigation.CreateTag -> {
                    navigateToCreatedTagSheet()
                }
            }
        }?.collect()
    }

    ModalBottomSheet(
        onDismissRequest = { navigateToFavourites() },
        sheetState = sheetState,
        modifier = Modifier
            .padding(bottomSheetMargins),
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {
            if (tagCreated) {
                CreatedTagView()
            } else {
                CreateTagView(onEventSent = onEventSent)
            }
        }
    }
}
