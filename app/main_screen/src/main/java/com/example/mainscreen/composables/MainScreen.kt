package com.example.mainscreen.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mainscreen.MainScreenContract
import kotlinx.coroutines.flow.Flow

@Composable
fun MainScreen(
    state: MainScreenContract.State,
    effectFlow: Flow<MainScreenContract.Effect>?,
    onEventSent: (event: MainScreenContract.Event) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state.shouldShowPreTranslateImage) {
            MainScreenImage()
        }

        val selectorsPaddingValues = PaddingValues(0.dp, 0.dp, 0.dp, 14.dp)

        LanguageSelectorRow(
            sourceState = state.sourceSelectorState,
            destinationState = state.destinationSelectorState,
            rowModifier = Modifier.padding(selectorsPaddingValues)
        )

        InputView(
            isKeyboardButtonVisible = state.shouldShowKeyboardButton,
            isPlaceholderVisible = state.shouldShowPlaceholder,
            onClick = { onEventSent(MainScreenContract.Event.InputViewClick) }
        )
    }
}