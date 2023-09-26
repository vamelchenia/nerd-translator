package com.example.mainscreen.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
        MainScreenImage()

        LanguageSelectorRow(
            sourceState = state.sourceSelectorState,
            destinationState = state.destinationSelectorState
        )

        InputView()
    }
}