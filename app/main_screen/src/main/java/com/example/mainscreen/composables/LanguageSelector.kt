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
import com.example.mainscreen.R

private val roundingSize = 5.dp
private val buttonPaddings = PaddingValues(30.dp, 10.dp, 20.dp, 10.dp)
private val errorColor = Color(0xFFF2575D)

@Composable
fun LanguageSelector(
    languageName: String,
    isError: Boolean = false,
    isExpanded: Boolean = false,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier.padding(8.dp)
    ) {
        val selectorContainerColor = when {
            isExpanded -> MaterialTheme.colorScheme.primary
            else -> MaterialTheme.colorScheme.tertiary
        }

        val selectorBorder = when {
            isError -> BorderStroke(1.dp, errorColor)
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
                isError -> errorColor
                isExpanded -> MaterialTheme.colorScheme.tertiary
                else -> MaterialTheme.colorScheme.primary
            }

            Text(
                text = languageName,
                color = textColor
            )

            val iconPainter = when {
                isExpanded -> painterResource(R.drawable.arrow_up_ic_24)
                else -> painterResource(R.drawable.arrow_down_ic_24)
            }

            val iconTint = when {
                isError -> errorColor
                isExpanded -> MaterialTheme.colorScheme.tertiary
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