package com.llcompany.nerdtranslator.base.main

import com.example.core.arch.ViewEffect
import com.example.core.arch.ViewEvent
import com.example.core.arch.ViewState

class BottomSheetContract {

    sealed class Event : ViewEvent {
        data object FavouritesScreenCreateTagActionClick : Event()
        data object CreateTagOnMainScreenActionClick : Event()
        data object TagCreatedOnMainScreenActionClick : Event()
        data object CreateTagOnFavouritesScreenActionClick : Event()
    }

    object State : ViewState

    sealed class Effect : ViewEffect {
        sealed class Navigation : Effect() {
            data object ToCreateTagOnFavouritesScreen : Effect()
            data object ToTagCreatedOnFavouritesScreen : Effect()
            data object ToCreateTagOnMainScreen : Effect()
            data object ToTagCreatedOnMainScreen : Effect()
        }
    }

}