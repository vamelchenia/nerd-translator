package com.example.mainscreen.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.mainscreen.MainScreenContract
import com.example.mainscreen.R

@Composable
fun LanguageSelectorRow(
    modifier: Modifier,
    sourceState: MainScreenContract.LanguageSelectorState,
    destinationState: MainScreenContract.LanguageSelectorState,
    swapButtonOnClick: () -> Unit = {}
) {
    val iconPainter = painterResource(R.drawable.change_icon)

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        LanguageSelector(state = sourceState)

        // TODO: make icon clickable and switch states on click
        IconButton(onClick = swapButtonOnClick) {
            Icon(
                painter = iconPainter,
                contentDescription = stringResource(R.string.language_selector_row_switch),
                tint = MaterialTheme.colorScheme.onSurface
            )
        }

        LanguageSelector(state = destinationState)
    }
}