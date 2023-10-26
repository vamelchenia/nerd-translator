package com.example.mainscreen.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
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
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val clipboardManager = LocalClipboardManager.current.getText()

        AnimatedVisibility(visible = state.shouldShowPreTranslateImage) {
            MainScreenImage()
        }

        val selectorsPaddingValues = PaddingValues(0.dp, 0.dp, 0.dp, 14.dp)

        LanguageSelectorRow(
            modifier = Modifier.padding(selectorsPaddingValues),
            sourceState = state.sourceSelectorState,
            destinationState = state.destinationSelectorState,
            swapButtonOnClick = { onEventSent(MainScreenContract.Event.SwapLanguages) }
        )

        InputView(
            modifier = Modifier.weight(1f),
            state = state.inputViewState,
            inputAreaOnClick = { onEventSent(MainScreenContract.Event.InputViewClick) },
            pasteButtonOnClick = {
                val text = clipboardManager?.text
                onEventSent(MainScreenContract.Event.PasteButtonClick(text))
            }
        )
    }
}