package com.example.favouritesscreen.composables

import com.example.tagscreen.composables.Tag
import androidx.compose.runtime.Composable
import com.example.favouritesscreen.FavouritesScreenContract

@Composable
fun TagList(state: FavouritesScreenContract.State) {
    //TODO: use from Core after implementation
    Tag(tagCount = state.tagCount)
}