package com.example.mainscreen

import com.llcompany.nerdtranslator.core.arch.ViewEffect
import com.llcompany.nerdtranslator.core.arch.ViewEvent
import com.llcompany.nerdtranslator.core.arch.ViewState

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