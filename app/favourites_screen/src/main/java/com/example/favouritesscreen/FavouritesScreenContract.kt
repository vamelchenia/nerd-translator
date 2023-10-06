package com.example.favouritesscreen

import com.example.core.arch.ViewEffect
import com.example.core.arch.ViewEvent
import com.example.core.arch.ViewState

class FavouritesScreenContract {

    sealed class Event : ViewEvent {
    }

    data class State(
        val isValid: Boolean,
        val buttonState: ButtonState
    ) : ViewState

    data class ButtonState(
        val buttonName: String,
        val onClick: () -> Unit = {},
        val isError: Boolean = false
        )

    sealed class Effect : ViewEffect {

    }
}