package com.llcompany.nerdtranslator.base.main

import com.example.core.arch.BaseViewModel

class BottomSheetViewModel : BaseViewModel<
        BottomSheetContract.State,
        BottomSheetContract.Event,
        BottomSheetContract.Effect>() {
    override fun setInitialState(): BottomSheetContract.State {
        return BottomSheetContract.State
    }

    override fun onEventReceived(event: BottomSheetContract.Event) {
        when (event) {
            BottomSheetContract.Event.CreateTagOnFavouritesActionClick -> {
                applyEffect {
                    BottomSheetContract.Effect.Navigation.ToCreateTag
                }
            }

            BottomSheetContract.Event.CreateTagActionClick -> {
                applyEffect {
                    BottomSheetContract.Effect.Navigation.ToTagCreated
                }
            }

            BottomSheetContract.Event.TagCreatedActionClick -> {}

        }
    }
}