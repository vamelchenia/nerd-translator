package com.example.mainscreen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mainscreen.R

@Composable
fun MainScreenImage() {
    val topHintMargins = PaddingValues(0.dp, 8.dp, 0.dp, 8.dp)
    val bottomHintMargins = PaddingValues(0.dp, 0.dp, 0.dp, 8.dp)

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
            fontSize = 14.sp,
            lineHeight = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(topHintMargins)
        )

        Text(
            text = stringResource(R.string.under_image_hint_secondary),
            color = MaterialTheme.colorScheme.tertiary,
            fontSize = 12.sp,
            lineHeight = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottomHintMargins)
        )
    }
}