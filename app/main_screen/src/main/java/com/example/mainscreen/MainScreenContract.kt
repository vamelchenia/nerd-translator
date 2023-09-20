package com.example.mainscreen

import com.example.core.arch.ViewEffect
import com.example.core.arch.ViewEvent
import com.example.core.arch.ViewState

class MainScreenContract {

    sealed class Event : ViewEvent {
        object RunTranslation : Event()
        object Retry : Event()
    }

    data class State(
        val query: String,
        val translatedQuery: String,
        val sourceSelectorState: LanguageSelectorState,
        val destinationSelectorState: LanguageSelectorState,
        val isValid: Boolean
    ) : ViewState

    data class LanguageSelectorState(
        val languageName: String,
        val isError: Boolean = false,
        val isExpanded: Boolean = false,
        val onClick: () -> Unit = {}
    )

    sealed class Effect : ViewEffect {
        // TODO: implement
    }
}