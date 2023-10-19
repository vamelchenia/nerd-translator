package com.example.tagscreen

import com.example.core.arch.BaseViewModel

class TagScreenViewModel :
    BaseViewModel<TagScreenContract.State, TagScreenContract.Event, TagScreenContract.Effect>() {

    override fun setInitialState(): TagScreenContract.State {
        return TagScreenContract.State(isValid = true)
    }

    override fun onEventReceived(event: TagScreenContract.Event) {

    }}