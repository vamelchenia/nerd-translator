package com.llcompany.nerdtranslator.base.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationHolder() {

    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = Navigation.Routes.MAIN_SCREEN
    ) {

        composable(
            route = Navigation.Routes.CREATE_TAG_SCREEN
        ) {
            // Create Tag Screen Destination Call
        }

        composable(
            route = Navigation.Routes.TAGS_OVERVIEW_SCREEN
        ) {
            // Tags Overview Screen Destination Call
        }
    }
}

object Navigation {

    object Routes {
        const val MAIN_SCREEN = "main"
        const val CREATE_TAG_SCREEN = "create_tag"
        const val TAGS_OVERVIEW_SCREEN = "tags_overview"
    }
}