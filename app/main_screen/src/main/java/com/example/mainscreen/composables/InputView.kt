package com.example.mainscreen.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

private val roundingSize = 20.dp

@Composable
fun defaultTextFieldColors() =
    TextFieldDefaults.colors(
        focusedContainerColor = MaterialTheme.colorScheme.background,
        unfocusedContainerColor = MaterialTheme.colorScheme.background
    )

@Composable
fun InputView(
    textFieldColors: TextFieldColors = defaultTextFieldColors()
) {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("Sample text")) }

    TextField(
        value = textFieldValue,
        onValueChange = { textFieldValue = it },
        colors = textFieldColors,
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(roundingSize, roundingSize, 0.dp, 0.dp)
    )
}