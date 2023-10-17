package com.example.createtagsheet.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.createtagsheet.R

private val labelMargins = PaddingValues(top = 10.dp, bottom = 6.dp)
private val hintMargins = PaddingValues(bottom = 16.dp)
private val labelColor = Color(0xFF001F35)
private val hintColor = Color(0xFF5A798F)

@Composable
private fun titleTextStyle(textColor: Color = labelColor) = MaterialTheme.typography.titleLarge.copy(
    textAlign = TextAlign.Center,
    color = textColor,
)

@Composable
private fun hintTextStyle(textColor: Color = hintColor) = MaterialTheme.typography.titleMedium.copy(
    fontSize = 14.sp,
    textAlign = TextAlign.Center,
    color = textColor,
)

@Composable
fun CreateTagHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.create_tag_image),
            contentDescription = stringResource(R.string.create_tag_image),
        )

        Text(
            modifier = Modifier.padding(labelMargins),
            text = stringResource(R.string.create_tag_title),
            style = titleTextStyle()
        )

        Text(
            modifier = Modifier.padding(hintMargins),
            text = stringResource(R.string.create_tag_hint),
            style = hintTextStyle()
        )
    }
}