package com.llcompany.nerdtranslator.base.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.llcompany.nerdtranslator.base.main.TopAppBarViewModel
import com.llcompany.nerdtranslator.base.main.ui.composables.NerdTranslatorAppBar
import org.koin.androidx.compose.getViewModel

@Composable
fun NavigationHolder() {

    val navController = rememberNavController()
    val appBarViewModel = getViewModel<TopAppBarViewModel>()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            NerdTranslatorAppBar(
                state = appBarViewModel.getState().value,
                effectFlow = appBarViewModel.currentEffect,
                onEventSent = { appBarViewModel.onEventReceived(it) },
                navigateToFavouries = { navController.navigateToFavourites() },
                navigateToSettings = {}
            )
        }
    ) { paddingValues ->
        NavHost(
            navController,
            startDestination = Navigation.Routes.MAIN_SCREEN,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(
                route = Navigation.Routes.MAIN_SCREEN
            ) {
                MainScreenDestination()
            }

            composable(
                route = Navigation.Routes.FAVOURITES_SCREEN
            ) {
                FavouritesScreenDestination()
            }

            composable(
                route = Navigation.Routes.CREATE_TAG_SHEET
            ) {
                // Create Tag Screen Destination Call
            }
        }
    }
}

object Navigation {

    object Routes {
        const val MAIN_SCREEN = "main"
        const val FAVOURITES_SCREEN = "favourites"
        const val CREATE_TAG_SHEET = "create_tag"
    }
}

fun NavController.navigateToFavourites() {
    navigate(
        route = Navigation.Routes.FAVOURITES_SCREEN
    )
}