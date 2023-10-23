package com.example.createtagsheet

import com.example.core.arch.ViewEffect
import com.example.core.arch.ViewEvent
import com.example.core.arch.ViewState

class CreateTagSheetContract {

    sealed class Event : ViewEvent {
        data object CreateButtonActionClick : Event()
    }

    data class State(
        val isValid: Boolean,
        var isCreated: Boolean,
    ) : ViewState

    sealed class Effect : ViewEffect {
        sealed class Navigation : Effect() {
            data object CreateTag : Effect()
        }
    }
}