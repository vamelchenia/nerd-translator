package com.example.mainscreen.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp

@Composable
fun LanguageSelector(
    languageName: String,
    isError: Boolean
) {
    Box(
        modifier = Modifier.padding(Dp(8f))
    ) {
        Button(
            onClick = {},
            shape = RoundedCornerShape(5),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.tertiary
            )
        ) {
            Text(
                text = languageName,
                color = MaterialTheme.colorScheme.primary
            )
//            Icon(
//                imageVector = ,
//                contentDescription =
//            )
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