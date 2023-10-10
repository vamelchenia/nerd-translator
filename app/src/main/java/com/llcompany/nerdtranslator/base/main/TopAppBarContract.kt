package com.llcompany.nerdtranslator.base.main

import com.example.core.arch.ViewEffect
import com.example.core.arch.ViewEvent
import com.example.core.arch.ViewState

class TopAppBarContract {

    sealed class Event : ViewEvent {
        data object FavouritesActionClick : Event()

        data object SettingsActionClick : Event()
    }

    object State : ViewState

    sealed class Effect : ViewEffect {
        data object NavigateToFavourites : Effect()

        data object NavigateToSettings : Effect()
    }
}