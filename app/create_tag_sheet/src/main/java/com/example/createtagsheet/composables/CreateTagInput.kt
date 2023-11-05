package com.example.createtagsheet.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.createtagsheet.R

private val layoutMargins = PaddingValues(bottom = 18.dp)
private val textMargins = PaddingValues(15.dp, 10.dp, 15.dp, 10.dp)
private val borderColor = Color(0xFFF2575D)
private val roundingSize = 8.dp

@Composable
private fun textStyle(defaultTextColor: Color = MaterialTheme.colorScheme.primary) =
    MaterialTheme.typography.bodyLarge.copy(
        color = defaultTextColor
    )

@Composable
private fun labelTextStyle(defaultTextColor: Color = borderColor) =
    MaterialTheme.typography.titleMedium.copy(
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        color = defaultTextColor,
    )

@Composable
fun CreateTagInput() {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }

    ConstraintLayout(
        modifier = Modifier
            .padding(layoutMargins)
    )
    {
        Box(
            modifier = Modifier
                .width(286.dp)
                .height(48.dp)
                .border(1.dp, borderColor, RoundedCornerShape(roundingSize))
                .background(
                    MaterialTheme.colorScheme.background,
                    shape = RoundedCornerShape(roundingSize)
                ),
        ) {
            BasicTextField(
                value = textFieldValue,
                onValueChange = { textFieldValue = it },
                textStyle = textStyle(),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(textMargins),
                cursorBrush = SolidColor(MaterialTheme.colorScheme.tertiary),
            )
        }

        Text(
            modifier = Modifier
                .width(123.dp)
                .height(15.dp)
                .offset(10.dp, 48.dp),
            text = stringResource(R.string.create_tag_label),
            style = labelTextStyle()
        )
    }
}
