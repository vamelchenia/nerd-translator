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
import com.llcompany.nerdtranslator.base.main.BottomSheetContract
import com.llcompany.nerdtranslator.base.main.BottomSheetViewModel
import com.llcompany.nerdtranslator.base.main.TopAppBarViewModel
import com.llcompany.nerdtranslator.base.main.ui.composables.NerdTranslatorAppBar
import com.llcompany.nerdtranslator.base.main.ui.composables.NerdTranslatorBottomSheet
import org.koin.androidx.compose.getViewModel

private val bottomSheetMargins = PaddingValues(top = 70.dp)
private val bottomSheetModifier = Modifier.padding(bottomSheetMargins)

@Composable
fun NavigationHolder() {

    val navController = rememberNavController()
    val appBarViewModel = getViewModel<TopAppBarViewModel>()
    val bottomSheetViewModel = getViewModel<BottomSheetViewModel>()
    val bottomSheetState = rememberModalBottomSheetState(true)
    var bottomSheetRoute by remember { mutableStateOf("") }

    Scaffold(containerColor = MaterialTheme.colorScheme.surface, topBar = {
        NerdTranslatorAppBar(state = appBarViewModel.getState().value,
            effectFlow = appBarViewModel.currentEffect,
            onEventSent = { appBarViewModel.onEventReceived(it) },
            navigateToFavourites = { navController.navigateToFavourites() },
            navigateToSettings = {},
            navigateToBackSheet = { navController.popBackStack() })

        NerdTranslatorBottomSheet(
            state = bottomSheetViewModel.getState().value,
            effectFlow = bottomSheetViewModel.currentEffect,
            onEventSent = { bottomSheetViewModel.onEventReceived(it) },
            bottomSheetNavigation = { route -> bottomSheetRoute = route },
            navigateToFavourites = { navController.navigateToFavourites() },
        ) {
            when (bottomSheetRoute) {
                Navigation.BottomSheetRoutes.CREATE_TAG_ON_FAVOURITES_SCREEN -> {
                    ModalBottomSheet(
                        onDismissRequest = { bottomSheetRoute = "" },
                        sheetState = bottomSheetState,
                        modifier = bottomSheetModifier,
                    ) {
                        CreateTagSheetDestination(
                            createNewTag = {
                                bottomSheetRoute = ""
                                bottomSheetViewModel.onEventReceived(
                                    BottomSheetContract.Event.CreateTagOnFavouritesScreenActionClick
                                )
                            },
                            tagCreated = {},
                        )
                    }
                }

                Navigation.BottomSheetRoutes.CREATE_TAG_ON_MAIN_SCREEN -> {
                    ModalBottomSheet(
                        onDismissRequest = { bottomSheetRoute = "" },
                        sheetState = bottomSheetState,
                        modifier = bottomSheetModifier,
                    ) {
                        CreateTagSheetDestination(
                            createNewTag = {
                                bottomSheetRoute = ""
                                bottomSheetViewModel.onEventReceived(
                                    BottomSheetContract.Event.CreateTagOnMainScreenActionClick
                                )
                            },
                            tagCreated = {},
                        )
                    }
                }

                Navigation.BottomSheetRoutes.TAG_CREATED_ON_MAIN_SCREEN -> {
                    ModalBottomSheet(
                        onDismissRequest = { bottomSheetRoute = "" },
                        sheetState = bottomSheetState,
                        modifier = bottomSheetModifier,
                    ) {
                        CreateTagSheetDestination(
                            createNewTag = {},
                            tagCreated = { bottomSheetRoute = "" },
                        )
                    }
                }
            }
        }
    }) { paddingValues ->
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
                FavouritesScreenDestination(navigateToCreateTagSheet = {
                    bottomSheetViewModel.onEventReceived(
                        BottomSheetContract.Event.FavouritesScreenCreateTagActionClick
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
    }

    object BottomSheetRoutes {
        const val CREATE_TAG_ON_FAVOURITES_SCREEN = "create_tag_on_favourites_screen"
        const val CREATE_TAG_ON_MAIN_SCREEN = "create_tag_on_main_screen"
        const val TAG_CREATED_ON_MAIN_SCREEN = "created_tag_on_main_screen"
    }
}

fun NavController.navigateToFavourites() {
    navigate(
        route = Navigation.Routes.FAVOURITES_SCREEN
    )
}