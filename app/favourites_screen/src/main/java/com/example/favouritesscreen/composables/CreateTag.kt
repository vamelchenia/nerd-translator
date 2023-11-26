package com.example.favouritesscreen.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val buttonColorPrimaryNormal = Color(0xFFF2575D)
private val buttonPaddings = PaddingValues(30.dp, 15.dp, 30.dp, 15.dp)

@Composable
private fun createButtonTextStyle() = MaterialTheme.typography.titleSmall.copy(
    color = MaterialTheme.colorScheme.background,
)

@Composable
private fun createButtonColors() = ButtonDefaults.buttonColors(
    containerColor = buttonColorPrimaryNormal
)

@Composable
fun CreateTag(
    buttonName: String = "",
    onCreateTagClick: () -> Unit
) {
    Button(
        onClick = { onCreateTagClick() },
        contentPadding = buttonPaddings,
        shape = RoundedCornerShape(size = 32.dp),
        modifier = Modifier
            .height(48.dp),
        colors = createButtonColors()
    ) {
        Text(
            text = buttonName,
            modifier = Modifier
                .height(18.dp),
            style = createButtonTextStyle(),
        )
    }
}