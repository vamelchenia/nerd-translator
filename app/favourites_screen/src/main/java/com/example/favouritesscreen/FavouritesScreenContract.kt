package com.example.favouritesscreen

import com.example.core.arch.ViewEffect
import com.example.core.arch.ViewEvent
import com.example.core.arch.ViewState

class FavouritesScreenContract {

    sealed class Event : ViewEvent {
        data object CreateTagActionClick : Event()
        data object RefreshValuesFromRepository : Event()
    }

    data class State(
        val isValid: Boolean,
        val tagCount: Int
    ) : ViewState

    sealed class Effect : ViewEffect {
        sealed class Navigation : Effect() {
            data object ToCreateTagSheet : Effect()
        }
    }
}