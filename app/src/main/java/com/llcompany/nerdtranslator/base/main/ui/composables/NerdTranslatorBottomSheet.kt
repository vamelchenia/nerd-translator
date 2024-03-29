package com.llcompany.nerdtranslator.base.main.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.llcompany.nerdtranslator.base.main.BottomSheetContract
import com.llcompany.nerdtranslator.base.navigation.Navigation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun NerdTranslatorBottomSheet(
    state: BottomSheetContract.State,
    effectFlow: Flow<BottomSheetContract.Effect>?,
    onEventSent: (event: BottomSheetContract.Event) -> Unit,
    bottomSheetNavigation: (String) -> Unit,
    content: @Composable () -> Unit
) {

    LaunchedEffect(true) {
        effectFlow?.onEach { effect ->
            when (effect) {
                is BottomSheetContract.Effect.Navigation.ToCreateTag -> {
                    bottomSheetNavigation(Navigation.Routes.CREATE_TAG_SHEET)
                }
                is BottomSheetContract.Effect.Navigation.ToTagCreated -> {
                    bottomSheetNavigation(Navigation.Routes.TAG_CREATED_SHEET)
                }
            }
        }?.collect()
    }

    content()
}