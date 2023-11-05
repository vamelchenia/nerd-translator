package com.example.favouritesscreen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.favouritesscreen.R

private val textMargins = PaddingValues(0.dp, 48.dp, 0.dp, 72.dp)

@Composable
private fun underImageHintTextStyle(hintColor: Color = MaterialTheme.colorScheme.primary) = MaterialTheme.typography.titleLarge.copy(
    fontSize = 18.sp,
    lineHeight = 26.sp,
    textAlign = TextAlign.Center,
    color = hintColor,
)

@Composable
fun FavouritesScreenImage() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.favourites_screen_image),
            contentDescription = stringResource(R.string.favourites_screen_image),
        )

        Text(
            modifier = Modifier.padding(textMargins),
            text = stringResource(R.string.under_image_hint),
            style = underImageHintTextStyle()
        )
    }
}