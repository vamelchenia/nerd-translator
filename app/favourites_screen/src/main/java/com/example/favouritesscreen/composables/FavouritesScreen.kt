package com.example.favouritesscreen.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun FavouritesScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FavouritesScreenImage()
        CreateButton()
    }
}