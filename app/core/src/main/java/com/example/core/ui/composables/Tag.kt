package com.example.core.ui.composables

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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


private val tagColorPrimaryNormal = Color(0xFFFFFFFF)
private val tagTextColor = Color(0xFF001F35)
private val tagCountColor = Color(0xFF5A798F)

private val activeTagColorPrimaryNormal = Color(0xFFFFFFFF)
private val activeTagTextColor = Color(0xFF001F35)
private val activeTagCountColor = Color(0xFF5A798F)

private val tagPaddings = PaddingValues(15.dp, 4.dp, 15.dp, 6.dp)

@Composable
private fun editButtonTextStyle() = MaterialTheme.typography.titleSmall.copy(
    color = tagTextColor
)

@Composable
private fun tagButtonColors() = ButtonDefaults.buttonColors(
    containerColor = tagColorPrimaryNormal
)

@Composable
private fun tagCountTextStyle() = MaterialTheme.typography.titleSmall.copy(
    color = tagCountColor
)


@Composable
fun Tag(
    tagName: String = "TagElement",
    tagCount: Int = 8,
    isActive: Boolean = false
) {

    Button(
        onClick = {},
        contentPadding = tagPaddings,
        shape = RoundedCornerShape(size = 35.dp),
        modifier = Modifier
            .width(IntrinsicSize.Min)
            .height(40.dp)
            .padding(4.dp),
        colors = tagButtonColors()
    ) {
        Text(
            text = "#$tagName",
            modifier = Modifier
                .height(19.dp),
            style = editButtonTextStyle(),
        )

        Text(
            text = " ($tagCount)  ",
            modifier = Modifier
                .height(19.dp),
            style = tagCountTextStyle(),
        )
    }
}