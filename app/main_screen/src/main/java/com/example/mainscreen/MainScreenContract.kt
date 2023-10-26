package com.example.mainscreen

import com.example.core.arch.ViewEffect
import com.example.core.arch.ViewEvent
import com.example.core.arch.ViewState

class MainScreenContract {

    sealed class Event : ViewEvent {
        data object RunTranslation : Event()
        data object Retry : Event()

        data object InputViewClick : Event()

        data class PasteButtonClick(
            val text: String?
        ) : Event()
    }

    data class State(
        val query: String,
        val translatedQuery: String,
        val sourceSelectorState: LanguageSelectorState,
        val destinationSelectorState: LanguageSelectorState,
        val isValid: Boolean,
        val shouldShowPreTranslateImage: Boolean,
        val inputViewState: InputViewState
    ) : ViewState

    data class LanguageSelectorState(
        val languageName: String,
        val isError: Boolean = false,
        val isExpanded: Boolean = false,
        val onClick: () -> Unit = {}
    ) : ViewState

    data class InputViewState(
        val shouldShowSecondaryInputViews: Boolean,
        val isFocused: Boolean
    ) : ViewState

    sealed class Effect : ViewEffect {
        // TODO: implement
    }
}