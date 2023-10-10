package com.example.mainscreen.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.mainscreen.MainScreenContract
import com.example.mainscreen.R

@Composable
fun LanguageSelectorRow(
    sourceState: MainScreenContract.LanguageSelectorState,
    destinationState: MainScreenContract.LanguageSelectorState,
    rowModifier: Modifier
) {
    val iconPainter = painterResource(R.drawable.change_icon)
    val colorBlue = Color(0xFF3B7091)

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = rowModifier
    ) {
        LanguageSelector(state = sourceState)

        // TODO: make icon clickable and switch states on click
        Icon(
            painter = iconPainter,
            contentDescription = stringResource(R.string.language_selector_row_switch),
            tint = colorBlue
        )

        LanguageSelector(state = destinationState)
    }
}