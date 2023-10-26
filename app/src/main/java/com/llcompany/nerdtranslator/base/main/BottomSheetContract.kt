package com.llcompany.nerdtranslator.base.main

import com.example.core.arch.ViewEffect
import com.example.core.arch.ViewEvent
import com.example.core.arch.ViewState

class BottomSheetContract {

    sealed class Event : ViewEvent {
        data object CreateTagOnFavouritesActionClick : Event()
        data object CreateTagActionClick : Event()
        data object TagCreatedActionClick : Event()
    }

    object State : ViewState

    sealed class Effect : ViewEffect {
        sealed class Navigation : Effect() {
            data object ToCreateTag : Effect()
            data object ToTagCreated : Effect()
        }
    }

}