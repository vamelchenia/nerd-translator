package com.example.mainscreen

import com.example.core.arch.BaseViewModel

class MainScreenViewModel
    : BaseViewModel<MainScreenContract.State, MainScreenContract.Event, MainScreenContract.Effect>() {
    override fun setInitialState(): MainScreenContract.State {
        TODO("Not yet implemented")
    }

    override fun onEventReceived(event: MainScreenContract.Event) {
        TODO("Not yet implemented")
    }
}