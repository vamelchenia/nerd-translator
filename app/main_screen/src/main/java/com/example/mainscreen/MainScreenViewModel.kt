package com.example.mainscreen

import com.example.core.arch.BaseViewModel

class MainScreenViewModel
    : BaseViewModel<MainScreenContract.State, MainScreenContract.Event, MainScreenContract.Effect>() {
    override fun setInitialState(): MainScreenContract.State {
        return MainScreenContract.State(
            query = "",
            translatedQuery = "",
            sourceSelectorState = MainScreenContract.LanguageSelectorState("Russian"),
            destinationSelectorState = MainScreenContract.LanguageSelectorState("English"),
            isValid = true
        )
    }

    override fun onEventReceived(event: MainScreenContract.Event) {

    }
}