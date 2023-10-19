package com.example.createtagsheet

import androidx.compose.foundation.layout.PaddingValues
import com.example.core.arch.ViewEffect
import com.example.core.arch.ViewEvent
import com.example.core.arch.ViewState

class CreateTagSheetContract {

    sealed class Event : ViewEvent {
    }

    data class State(
        val isValid: Boolean,
        val isCreated: Boolean,
        val contentPaddingBottomSheet: PaddingValues
    ) : ViewState

    sealed class Effect : ViewEffect {

    }
}