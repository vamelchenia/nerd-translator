package com.example.favouritesscreen

import com.example.core.arch.BaseViewModel
import com.example.core.tags.TagsManagerRepository

class FavouritesScreenViewModel(
    private val tagsRepository: TagsManagerRepository
) : BaseViewModel<
        FavouritesScreenContract.State,
        FavouritesScreenContract.Event,
        FavouritesScreenContract.Effect>() {

    override fun setInitialState(): FavouritesScreenContract.State {
        return FavouritesScreenContract.State(
            isValid = true,
            tagsNumber = 0
        )
    }

    override fun onEventReceived(event: FavouritesScreenContract.Event) {
        when (event) {
            FavouritesScreenContract.Event.CreateTagActionClick -> {
                applyEffect {
                    FavouritesScreenContract.Effect.Navigation.ToCreateTagSheet
                }
            }

            FavouritesScreenContract.Event.RefreshRepositoryValues -> {
                val updatedTagsNumber = tagsRepository.getTagsNumber()
                setState {
                    copy(tagsNumber = updatedTagsNumber)
                }
            }
        }
    }
}

