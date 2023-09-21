package com.example.mainscreen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.mainscreen.R

// TODO: double line
// TODO: text line interval
@Composable
fun MainScreenImage() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.main_screen_image),
            contentDescription = stringResource(R.string.main_screen_image)
        )

        Text(
            text = stringResource(R.string.under_image_hint_primary),
            color = MaterialTheme.colorScheme.secondary,
            fontSize = 14.sp
        )

        Text(
            text = stringResource(R.string.under_image_hint_secondary),
            color = MaterialTheme.colorScheme.tertiary,
            fontSize = 12.sp
        )
    }
}