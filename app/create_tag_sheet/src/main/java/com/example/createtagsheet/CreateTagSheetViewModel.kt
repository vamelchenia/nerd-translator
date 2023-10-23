package com.example.createtagsheet

import com.example.core.arch.BaseViewModel

class CreateTagSheetViewModel :
    BaseViewModel<CreateTagSheetContract.State, CreateTagSheetContract.Event, CreateTagSheetContract.Effect>() {

    override fun setInitialState(): CreateTagSheetContract.State {
        return CreateTagSheetContract.State(
            isValid = false,
            isCreated = false,
        )
    }

    override fun onEventReceived(event: CreateTagSheetContract.Event) {
        when (event) {
            CreateTagSheetContract.Event.CreateButtonActionClick -> {
                applyEffect {
                    CreateTagSheetContract.Effect.Navigation.CreateTag
                }
            }
        }
    }

    fun switchIsValid(isValid: Boolean) {
        setState {
            copy(isValid = isValid)
        }
    }

    fun switchIsCreated(isCreated: Boolean) {
        setState {
            copy(isCreated = isCreated)
        }
    }
}