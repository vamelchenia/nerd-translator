package com.example.favouritesscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
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
            tagsState = FavouritesScreenContract.TagsState.NoTags
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
                    val areTagsExisting by mutableStateOf(tagsRepository.areTagsExisting())
                    val isFirstTag by mutableStateOf(tagsRepository.isFirstTag())
                    val tagsNumber by mutableIntStateOf(tagsRepository.getTagsNumber())
                    val tagsState by mutableStateOf(getTagsState(isFirstTag, areTagsExisting))
                    copy(
                        areTagsExisting = areTagsExisting,
                        isFirstTag = isFirstTag,
                        tagsNumber = tagsNumber,
                        tagsState = tagsState
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

