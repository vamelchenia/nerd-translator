package com.llcompany.nerdtranslator.base.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.createtagsheet.CreateTagSheetViewModel
import com.llcompany.nerdtranslator.base.main.BottomSheetContract
import com.llcompany.nerdtranslator.base.main.BottomSheetViewModel
import com.llcompany.nerdtranslator.base.main.TopAppBarViewModel
import com.llcompany.nerdtranslator.base.main.ui.composables.NerdTranslatorAppBar
import com.llcompany.nerdtranslator.base.main.ui.composables.NerdTranslatorBottomSheet
import org.koin.androidx.compose.getViewModel


private val bottomSheetMargins = PaddingValues(top = 70.dp)

@Composable
fun NavigationHolder() {

    val navController = rememberNavController()
    val appBarViewModel = getViewModel<TopAppBarViewModel>()
    val bottomSheetViewModel = getViewModel<BottomSheetViewModel>()
    val createTagSheetViewModel = getViewModel<CreateTagSheetViewModel>()
    val sheetState = rememberModalBottomSheetState(true)
    var bottomSheetRoute by remember { mutableStateOf("") }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            NerdTranslatorAppBar(
                state = appBarViewModel.getState().value,
                effectFlow = appBarViewModel.currentEffect,
                onEventSent = { appBarViewModel.onEventReceived(it) },
                navigateToFavourites = { navController.navigateToFavourites() },
                navigateToSettings = {},
                navigateToBackSheet = { navController.popBackStack() }
            )

            NerdTranslatorBottomSheet(
                state = bottomSheetViewModel.getState().value,
                effectFlow = bottomSheetViewModel.currentEffect,
                onEventSent = { bottomSheetViewModel.onEventReceived(it) },
                bottomSheetNavigation = { route -> bottomSheetRoute = route },
            ) {
                when (bottomSheetRoute) {
                    Navigation.Routes.CREATE_TAG_SHEET -> {
                        ModalBottomSheet(
                            onDismissRequest = { bottomSheetRoute = "" },
                            sheetState = sheetState,
                            modifier = Modifier
                                .padding(bottomSheetMargins),
                        ) {
                            CreateTagSheetDestination(
                                createNewTag = {
                                    createTagSheetViewModel.setIsCreated(true)
                                    bottomSheetRoute = ""
                                    bottomSheetViewModel.onEventReceived(
                                        BottomSheetContract.Event.CreateTagActionClick
                                    )
                                },
                                tagCreated = {},
                            )
                        }
                    }

                    Navigation.Routes.TAG_CREATED_SHEET -> {
                        ModalBottomSheet(
                            onDismissRequest = { bottomSheetRoute = "" },
                            sheetState = sheetState,
                            modifier = Modifier
                                .padding(bottomSheetMargins),
                        ) {
                            CreateTagSheetDestination(
                                createNewTag = {},
                                tagCreated = { bottomSheetRoute = "" },
                            )
                        }
                    }
                }
            }
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
                FavouritesScreenDestination(
                    navigateToCreateTagSheet = {
                        bottomSheetViewModel.onEventReceived(
                            BottomSheetContract.Event.CreateTagOnFavouritesActionClick
                        )
                    })
            }
        }
    }
}

object Navigation {

    object Routes {
        const val MAIN_SCREEN = "main"
        const val FAVOURITES_SCREEN = "favourites"
        const val CREATE_TAG_SHEET = "create_tag"
        const val TAG_CREATED_SHEET = "created_tag"
    }
}

fun NavController.navigateToFavourites() {
    navigate(
        route = Navigation.Routes.FAVOURITES_SCREEN
    )
}
