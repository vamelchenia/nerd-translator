package com.example.mainscreen

import com.example.core.arch.BaseViewModel

class MainScreenViewModel
    : BaseViewModel<MainScreenContract.State, MainScreenContract.Event, MainScreenContract.Effect>() {
    override fun setInitialState(): MainScreenContract.State {
        return MainScreenContract.State(
            query = "",
            translatedQuery = "",
            sourceSelectorState = MainScreenContract.LanguageSelectorState("RUSSIAN"),
            destinationSelectorState = MainScreenContract.LanguageSelectorState("ENGLISH"),
            isValid = true,
            shouldShowPreTranslateImage = true
        )
    }

    override fun onEventReceived(event: MainScreenContract.Event) {
        when(event) {
            is MainScreenContract.Event.InputViewClick -> {
                processInputViewClick()
            }
            else -> {
                // TODO: implement
            }
        }
    }

    private fun processInputViewClick() {
        setState {
            copy(
                shouldShowPreTranslateImage = false
            )
        }
    }
}