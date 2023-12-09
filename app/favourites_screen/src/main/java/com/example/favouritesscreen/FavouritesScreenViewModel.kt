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
            areTagsExisting = false,
            isFirstTag = false,
            tagsNumber = 0,
            tagsState = getTagsState(
                isFirstTag = false,
                areTagsExisting = false
            )
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
                setState {
                    copy(areTagsExisting = tagsRepository.areTagsExisting())
                }
                setState {
                    copy(isFirstTag = tagsRepository.isFirstTag())
                }
                setState {
                    copy(tagsNumber = tagsRepository.getTagsNumber())
                }
                setState {
                    copy(
                        tagsState = getTagsState(
                            isFirstTag,
                            areTagsExisting
                        )
                    )
                }
            }
        }
    }

    private fun getTagsState(
        isFirstTag: Boolean,
        areTagsExisting: Boolean
    ): FavouritesScreenContract.TagsState {
        var result = FavouritesScreenContract.TagsState.NoTags
        if (areTagsExisting) {
            result = when (isFirstTag) {
                true -> FavouritesScreenContract.TagsState.FirstTag
                false -> FavouritesScreenContract.TagsState.ExistingTags
            }
        }
        return result
    }
}

