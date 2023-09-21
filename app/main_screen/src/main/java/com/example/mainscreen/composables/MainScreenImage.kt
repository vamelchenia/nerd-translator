package com.example.mainscreen.composables

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.mainscreen.R

@Composable
fun MainScreenImage() {
    Image(
        painter = painterResource(R.drawable.main_screen_image),
        contentDescription = stringResource(R.string.main_screen_image))
}