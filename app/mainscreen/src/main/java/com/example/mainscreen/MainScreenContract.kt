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
        val sourceLanguage: String,
        val destinationLanguage: String,
        val isValid: Boolean
    ) : ViewState

    sealed class Effect : ViewEffect {
        // TODO: implement
    }
}