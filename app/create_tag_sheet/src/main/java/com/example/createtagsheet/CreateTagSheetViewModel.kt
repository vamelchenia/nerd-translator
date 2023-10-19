package com.example.createtagsheet

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import com.example.core.arch.BaseViewModel

class CreateTagSheetViewModel :
    BaseViewModel<CreateTagSheetContract.State, CreateTagSheetContract.Event, CreateTagSheetContract.Effect>() {

    override fun setInitialState(): CreateTagSheetContract.State {
        return CreateTagSheetContract.State(
            isValid = false,
            isCreated = false,
            contentPaddingBottomSheet = PaddingValues(0.dp)
        )
    }

    override fun onEventReceived(event: CreateTagSheetContract.Event) {

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

    fun updateContentPaddingBottomSheet(contentPaddingBottomSheet: PaddingValues) {
        setState {
            copy(contentPaddingBottomSheet = contentPaddingBottomSheet)
        }
    }
}