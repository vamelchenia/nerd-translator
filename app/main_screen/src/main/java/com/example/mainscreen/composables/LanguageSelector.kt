package com.example.mainscreen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LanguageSelector(
    languageName: String,
    isError: Boolean
) {
    Button(
        onClick = {},
        shape = RoundedCornerShape(5),
        modifier = Modifier.background(
            color = MaterialTheme.colorScheme.background
        )
    ) {
        Text(
            color = MaterialTheme.colorScheme.primary,
            text = languageName
        )
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