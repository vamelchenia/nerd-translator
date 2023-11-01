package com.example.tagscreen.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


private val buttonColorPrimaryNormal = Color(0xFF99AEBD)
private val buttonTextColor = Color(0xFFFFFFFF)
private val buttonPaddings = PaddingValues(30.dp, 12.dp, 30.dp, 12.dp)

@Composable
private fun editButtonTextStyle() = MaterialTheme.typography.titleSmall.copy(
    color = buttonTextColor
)

@Composable
private fun tagButtonColors() = ButtonDefaults.buttonColors(
    containerColor = buttonColorPrimaryNormal
)

@Composable
fun EditButton() {
    Button(
        onClick = {},
        contentPadding = buttonPaddings,
        shape = RoundedCornerShape(size = 32.dp),
        modifier = Modifier
            .width(125.dp)
            .height(48.dp),
        colors = tagButtonColors()
    ) {
        Text(
            text = "Edit tags",
            modifier = Modifier
                .width(77.dp)
                .height(18.dp),
            style = editButtonTextStyle(),
        )
    }
}