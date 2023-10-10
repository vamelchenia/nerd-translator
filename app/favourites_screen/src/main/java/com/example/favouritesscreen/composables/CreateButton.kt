package com.example.favouritesscreen.composables

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.favouritesscreen.R

private val buttonColorPrimaryNormal = Color(0xFFF2575D)
private val buttonTextColor = Color(0xFFFFFFFF)
private val buttonPaddings = PaddingValues(30.dp, 15.dp, 30.dp, 15.dp)

@Composable
private fun createButtonTextStyle() = MaterialTheme.typography.titleSmall.copy(
    color = buttonTextColor,
)

@Composable
private fun createButtonColors() = ButtonDefaults.buttonColors(
    containerColor = buttonColorPrimaryNormal
)

@Composable
fun CreateButton() {
    Button(
        onClick = {},
        contentPadding = buttonPaddings,
        shape = RoundedCornerShape(size = 32.dp),
        modifier = Modifier
            .width(137.dp)
            .height(48.dp),
        colors = createButtonColors()
    ) {
        Text(
            text = stringResource(R.string.create_button_name),
            modifier = Modifier
                .width(77.dp)
                .height(18.dp),
            style = createButtonTextStyle(),
        )
    }
}