package com.example.createtagsheet

import com.example.core.arch.BaseViewModel
import com.example.core.tags.TagsManagerRepository

class CreateTagSheetViewModel(
    private val tagsRepository: TagsManagerRepository
) : BaseViewModel<
        CreateTagSheetContract.State,
        CreateTagSheetContract.Event,
        CreateTagSheetContract.Effect>() {

    override fun setInitialState(): CreateTagSheetContract.State {
        return CreateTagSheetContract.State(
            isCreated = false,
        )
    }

    override fun onEventReceived(event: CreateTagSheetContract.Event) {
        when (event) {
            is CreateTagSheetContract.Event.CreateButtonActionClick -> {
                tagsRepository.createTag(event.tagName)
                applyEffect {
                    CreateTagSheetContract.Effect.Navigation.CreateTag
                }
            }

            CreateTagSheetContract.Event.TagCreatedButtonActionClick -> {
                applyEffect {
                    CreateTagSheetContract.Effect.Navigation.TagCreated
                }
            }

            is CreateTagSheetContract.Event.SetIsCreated -> {
                setIsCreated(event.isCreated)
            }
        }
    }

    private fun setIsCreated(isCreated: Boolean) {
        setState {
            copy(isCreated = isCreated)
        }
    }
}