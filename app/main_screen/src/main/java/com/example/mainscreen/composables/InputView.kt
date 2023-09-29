package com.example.mainscreen.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mainscreen.R

private val roundingSize = 20.dp

@Composable
fun defaultTextFieldColors() =
    TextFieldDefaults.colors(
        focusedContainerColor = MaterialTheme.colorScheme.background,
        unfocusedContainerColor = MaterialTheme.colorScheme.background
    )

@Composable
fun inputViewTextStyle(
    textColor: Color = Color(0xFF001F35)
) = TextStyle(
    fontSize = 20.sp,
    lineHeight = 28.sp,
    color = textColor
)

// TODO: configure maximum vertical expansion
@Composable
fun InputView(
    textFieldColors: TextFieldColors = defaultTextFieldColors()
) {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (inputArea, keyboardButton) = createRefs()

        TextField(
            value = textFieldValue,
            onValueChange = { textFieldValue = it },
            colors = textFieldColors,
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(inputArea) {
                    centerHorizontallyTo(parent)
                },
            shape = RoundedCornerShape(roundingSize, roundingSize, 0.dp, 0.dp),
            textStyle = inputViewTextStyle(),
            placeholder = {
                Text(
                    text = stringResource(R.string.input_view_hint),
                    style = inputViewTextStyle(Color(0xFFA3ADB5))
                )
            }
        )

        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .constrainAs(keyboardButton) {
                    centerHorizontallyTo(inputArea)
                    bottom.linkTo(inputArea.bottom, margin = 24.5.dp)
                }
                .size(70.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.btn_keyboard),
                contentDescription = stringResource(R.string.language_selector_expand_more),
                tint = Color.Unspecified
            )
        }
    }
}