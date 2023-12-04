package com.example.favouritesscreen.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.favouritesscreen.FavouritesScreenContract
import com.example.favouritesscreen.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

private val labelMargins = PaddingValues(top = 92.dp, bottom = 6.dp)
private val hintMargins = PaddingValues(bottom = 130.dp)

@Composable
private fun titleTextStyle(textColor: Color = MaterialTheme.colorScheme.primary) =
    MaterialTheme.typography.titleLarge.copy(
        textAlign = TextAlign.Center,
        color = textColor,
    )

@Composable
private fun hintTextStyle(textColor: Color = MaterialTheme.colorScheme.secondary) =
    MaterialTheme.typography.titleMedium.copy(
        fontSize = 14.sp,
        textAlign = TextAlign.Center,
        color = textColor,
    )

@Composable
fun FavouritesFirstTagScreen(
    state: FavouritesScreenContract.State,
    effectFlow: Flow<FavouritesScreenContract.Effect>?,
    onEventSent: (event: FavouritesScreenContract.Event) -> Unit,
    navigateToCreateTagSheet: () -> Unit,
) {

    LaunchedEffect(true) {
        effectFlow?.onEach { effect ->
            when (effect) {
                is FavouritesScreenContract.Effect.Navigation.ToCreateTagSheet -> {
                    navigateToCreateTagSheet()
                }
            }
        }?.collect()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        TagList(state)

        Text(
            modifier = Modifier.padding(labelMargins),
            text = stringResource(R.string.first_tag_title),
            style = titleTextStyle()
        )

        Text(
            modifier = Modifier.padding(hintMargins),
            text = stringResource(R.string.first_tag_hint),
            style = hintTextStyle()
        )

        CreateTag(stringResource(R.string.create_new_tag_button_name))
        { onEventSent(FavouritesScreenContract.Event.CreateTagActionClick) }
    }
}