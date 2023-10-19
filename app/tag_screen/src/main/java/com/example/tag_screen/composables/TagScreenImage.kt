package com.example.tagscreen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tag_screen.R

private val textMargins = PaddingValues(0.dp, 8.dp, 0.dp, 12.dp)
private val textColor = Color(0xFF001F35)

@Composable
private fun underImageHintTextStyle(hintColor: Color = textColor) = MaterialTheme.typography.titleLarge.copy(
    fontSize = 18.sp,
    lineHeight = 26.sp,
    textAlign = TextAlign.Center,
    color = hintColor,
    fontWeight = FontWeight.Bold
)


@Composable
@Preview
fun TagScreenImage() {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.tag_screen_image),
                contentDescription = stringResource(R.string.tag_screen_image),
            )

            Text(
                modifier = androidx.compose.ui.Modifier.padding(textMargins),
                text = "Active tag",
                style = underImageHintTextStyle()
            )
        }

}