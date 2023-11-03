package com.example.mainscreen

import com.example.core.arch.BaseViewModel

class MainScreenViewModel
    :
    BaseViewModel<MainScreenContract.State, MainScreenContract.Event, MainScreenContract.Effect>() {
    override fun setInitialState(): MainScreenContract.State {
        return MainScreenContract.State(
            query = "",
            translatedQuery = "",
            sourceSelectorState = MainScreenContract.LanguageSelectorState("RUSSIAN"),
            destinationSelectorState = MainScreenContract.LanguageSelectorState("ENGLISH"),
            isValid = true,
            shouldShowPreTranslateImage = true,
            inputViewState = MainScreenContract.InputViewState(
                shouldShowSecondaryInputViews = true,
                isFocused = false,
                pasteButtonState = MainScreenContract.PasteButtonState(
                    isVisible = true
                )
            )
        )
    }

    override fun onEventReceived(event: MainScreenContract.Event) {
        when (event) {
            is MainScreenContract.Event.InputViewClick -> {
                processInputViewClick()
            }
            is MainScreenContract.Event.PasteButtonClick -> {
                processPasteButtonClick(event.text)
            }
            is MainScreenContract.Event.SwapLanguages -> {
                processSwapLanguages()
            }
            else -> {
                // TODO: implement
            }
        }
    }

    private fun processInputViewClick() {
        setState {
            val newInputViewState = inputViewState.copy(
                shouldShowSecondaryInputViews = false,
                isFocused = true
            )

            copy(
                shouldShowPreTranslateImage = false,
                inputViewState = newInputViewState
            )
        }
    }

    private fun processPasteButtonClick(text: String?) {
        text ?: return
        setState {
            copy(
                query = text
            )
        }
    }

    private fun processSwapLanguages() {
        setState {
            val destinationSelectorNewState = destinationSelectorState.copy(
                languageName = sourceSelectorState.languageName
            )

            val sourceSelectorNewState = sourceSelectorState.copy(
                languageName = destinationSelectorState.languageName
            )

            copy(
                sourceSelectorState = sourceSelectorNewState,
                destinationSelectorState = destinationSelectorNewState
            )
        }
    }
}