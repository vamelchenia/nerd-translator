package com.example.createtagsheet

import com.example.core.arch.BaseViewModel

class CreateTagSheetViewModel :
    BaseViewModel<CreateTagSheetContract.State, CreateTagSheetContract.Event, CreateTagSheetContract.Effect>() {

    override fun setInitialState(): CreateTagSheetContract.State {
        return CreateTagSheetContract.State(
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

            CreateTagSheetContract.Event.TagCreatedButtonActionClick -> {
                applyEffect {
                    CreateTagSheetContract.Effect.Navigation.TagCreated
                }
            }

        }
    }

    fun setIsCreated(isCreated: Boolean) {
        setState {
            copy(isCreated = isCreated)
        }
    }
}