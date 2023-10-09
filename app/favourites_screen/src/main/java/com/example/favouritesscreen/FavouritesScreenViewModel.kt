package com.example.favouritesscreen

import com.example.core.arch.BaseViewModel

class FavouritesScreenViewModel :
    BaseViewModel<FavouritesScreenContract.State, FavouritesScreenContract.Event, FavouritesScreenContract.Effect>() {

    override fun setInitialState(): FavouritesScreenContract.State {
        return FavouritesScreenContract.State(isValid = true)
    }

    override fun onEventReceived(event: FavouritesScreenContract.Event) {

    }
}