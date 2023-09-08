package com.example.mainscreen.composables

import androidx.compose.runtime.Composable
import com.example.mainscreen.MainScreenContract
import kotlinx.coroutines.flow.Flow

@Composable
fun MainScreen(
    state: MainScreenContract.State,
    effectFlow: Flow<MainScreenContract.Effect>?,
    onEventSent: (event: MainScreenContract.Event) -> Unit,
) {
    LanguageSelector(
        languageName = "English",
        isError = false
    )
}