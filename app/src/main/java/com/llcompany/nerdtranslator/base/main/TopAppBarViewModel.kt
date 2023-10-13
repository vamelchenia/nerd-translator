package com.llcompany.nerdtranslator.base.main

import com.example.core.arch.BaseViewModel

class TopAppBarViewModel : BaseViewModel<
        TopAppBarContract.State,
        TopAppBarContract.Event,
        TopAppBarContract.Effect>()
{
    override fun setInitialState(): TopAppBarContract.State {
        return TopAppBarContract.State
    }

    override fun onEventReceived(event: TopAppBarContract.Event) {
        when(event) {
            TopAppBarContract.Event.FavouritesActionClick -> {
                applyEffect {
                    TopAppBarContract.Effect.Navigation.ToFavourites
                }
            }
            TopAppBarContract.Event.SettingsActionClick -> {
                applyEffect {
                    TopAppBarContract.Effect.Navigation.ToSettings
                }
            }
            TopAppBarContract.Event.BackSheetActionClick -> {
                applyEffect {
                    TopAppBarContract.Effect.Navigation.ToBackSheet
                }
            }
        }
    }
}