package com.example.mainscreen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private val roundingSize = 20.dp

@Composable
fun InputView() {
    var textValue by remember { mutableStateOf("Sample text") }

    Box(
        modifier = Modifier.background(
            color = MaterialTheme.colorScheme.background,
            shape = RoundedCornerShape(roundingSize)
        )
    ) {
        TextField(
            value = textValue,
            onValueChange = { textValue = it }
        )
    }
}