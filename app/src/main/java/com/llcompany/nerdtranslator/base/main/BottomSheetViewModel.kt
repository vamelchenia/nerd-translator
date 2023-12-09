package com.llcompany.nerdtranslator.base.main

import com.example.core.arch.BaseViewModel
import com.example.core.tags.TagsManagerRepository

class BottomSheetViewModel(
    private val tagsRepository: TagsManagerRepository
) : BaseViewModel<
        BottomSheetContract.State,
        BottomSheetContract.Event,
        BottomSheetContract.Effect>() {

    override fun setInitialState(): BottomSheetContract.State {
        return BottomSheetContract.State
    }

    override fun onEventReceived(event: BottomSheetContract.Event) {
        when (event) {
            BottomSheetContract.Event.FavouritesScreenCreateTagActionClick -> {
                applyEffect {
                    BottomSheetContract.Effect.Navigation.ToCreateTagOnFavouritesScreen
                }
            }

            BottomSheetContract.Event.CreateTagOnFavouritesScreenActionClick -> {
                tagsRepository.createTag()
                applyEffect {
                    BottomSheetContract.Effect.Navigation.ToTagCreatedOnFavouritesScreen
                }
            }

            BottomSheetContract.Event.CreateTagOnMainScreenActionClick -> {}

            BottomSheetContract.Event.TagCreatedOnMainScreenActionClick -> {}
        }
    }
}