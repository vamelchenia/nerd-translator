package com.example.tagscreen

import com.example.core.arch.ViewEffect
import com.example.core.arch.ViewEvent
import com.example.core.arch.ViewState

class TagScreenContract {
    sealed class Event : ViewEvent {
    }

    data class State(
        val isValid: Boolean
    ) : ViewState

    sealed class Effect : ViewEffect {

    }
}