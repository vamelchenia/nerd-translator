package com.llcompany.nerdtranslator.base.navigation

import androidx.compose.runtime.Composable
import com.example.mainscreen.MainScreenViewModel
import com.example.mainscreen.composables.MainScreen
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreenDestination() {
    val viewModel = getViewModel<MainScreenViewModel>()
    MainScreen(
        viewModel.getState().value,
        viewModel.currentEffect,
        onEventSent = { event -> viewModel.onEventReceived(event)  }
    )
}