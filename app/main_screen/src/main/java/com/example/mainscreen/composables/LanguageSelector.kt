package com.example.mainscreen.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mainscreen.MainScreenContract
import com.example.mainscreen.R

private val roundingSize = 5.dp
private val buttonPaddings = PaddingValues(30.dp, 10.dp, 20.dp, 10.dp)
private val errorColor = Color(0xFFF2575D)

@Composable
fun LanguageSelector(
    state: MainScreenContract.LanguageSelectorState
) {
    Box(
        modifier = Modifier.padding(8.dp)
    ) {
        val selectorContainerColor = when {
            state.isExpanded -> MaterialTheme.colorScheme.primary
            else -> MaterialTheme.colorScheme.background
        }

        val selectorBorder = when {
            state.isError -> BorderStroke(1.dp, errorColor)
            else -> null
        }

        Button(
            onClick = {},
            shape = RoundedCornerShape(roundingSize),
            colors = ButtonDefaults.buttonColors(
                containerColor = selectorContainerColor
            ),
            contentPadding = buttonPaddings,
            border = selectorBorder
        ) {

            val textColor = when {
                state.isError -> errorColor
                state.isExpanded -> MaterialTheme.colorScheme.background
                else -> MaterialTheme.colorScheme.primary
            }

            Text(
                text = state.languageName,
                color = textColor
            )

            val iconPainter = when {
                state.isExpanded -> painterResource(R.drawable.arrow_up_ic_24)
                else -> painterResource(R.drawable.arrow_down_ic_24)
            }

            val iconTint = when {
                state.isError -> errorColor
                state.isExpanded -> MaterialTheme.colorScheme.background
                else -> MaterialTheme.colorScheme.secondary
            }

            Icon(
                painter = iconPainter,
                contentDescription = stringResource(R.string.language_selector_expand_more),
                tint = iconTint
            )
        }
    }
}