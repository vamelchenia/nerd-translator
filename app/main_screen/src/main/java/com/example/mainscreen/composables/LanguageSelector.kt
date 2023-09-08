package com.example.mainscreen.composables

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mainscreen.R

private val roundingSize = 5.dp
private val buttonPaddings = PaddingValues(30.dp, 10.dp, 20.dp, 10.dp)

@Composable
fun LanguageSelector(
    languageName: String,
    isError: Boolean
) {
    Box(
        modifier = Modifier.padding(8.dp)
    ) {
        Button(
            onClick = {},
            shape = RoundedCornerShape(roundingSize),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.tertiary
            ),
            contentPadding = buttonPaddings
        ) {
            Text(
                text = languageName,
                color = MaterialTheme.colorScheme.primary
            )
            Icon(
                painter = painterResource(R.drawable.arrow_down_ic_24),
                contentDescription = stringResource(R.string.language_selector_expand_more),
                tint = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LanguageSelectorPreview() {
    LanguageSelector(
        "English",
        false
    )
}