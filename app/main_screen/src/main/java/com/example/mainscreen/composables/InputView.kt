package com.example.mainscreen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mainscreen.MainScreenContract
import com.example.mainscreen.R

private val roundingSize = 20.dp

@Composable
fun inputViewTextStyle(
    textColor: Color = Color(0xFF001F35)
) = MaterialTheme.typography.bodyLarge.copy(
    color = textColor
)

// TODO: propagate annotation
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputView(
    modifier: Modifier = Modifier,
    state: MainScreenContract.InputViewState,
    onClick: () -> Unit = {}
) {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    val interactionSource = remember { MutableInteractionSource() }
        .also { source ->
            LaunchedEffect(source) {
                source.interactions.collect {
                    when (it) {
                        is PressInteraction.Release -> {
                            if (!state.isFocused) {
                                onClick()
                            }
                        }
                    }
                }
            }
        }
    val shape = RoundedCornerShape(roundingSize, roundingSize, 0.dp, 0.dp)

    ConstraintLayout(
        modifier = modifier
    ) {
        val (inputArea, pasteButton, keyboardButton) = createRefs()

        BasicTextField(
            value = textFieldValue,
            onValueChange = { textFieldValue = it },
            modifier = Modifier
                .clip(shape)
                .background(color = MaterialTheme.colorScheme.background)
                .constrainAs(inputArea) {
                    centerHorizontallyTo(parent)
                },
            interactionSource = interactionSource,
        ) {
            TextFieldDefaults.DecorationBox(
                value = textFieldValue.text,
                innerTextField = {
                    Row(
                        modifier = Modifier
                            .background(
                                color = MaterialTheme.colorScheme.background,
                                shape = shape
                            ).fillMaxSize()
                    ) {
                        Text(
                            text = textFieldValue.text,
                            modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
                            style = inputViewTextStyle()
                        )
                    }
                },
                enabled = true,
                singleLine = false,
                placeholder = {
                    if (state.shouldShowSecondaryInputViews) {
                        Placeholder()
                    }
                },
                visualTransformation = VisualTransformation.None,
                interactionSource = interactionSource,
                contentPadding = PaddingValues(0.dp)
            )
        }

        if (state.shouldShowSecondaryInputViews) {
            PasteButtonContainer(
                pasteButtonContainerModifier = Modifier
                    .constrainAs(pasteButton) {
                        top.linkTo(inputArea.top, margin = 70.dp)
                        start.linkTo(inputArea.start)
                    }
            )

            IconButton(
                onClick = { onClick() },
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
}

@Composable
fun Placeholder() {
    Text(
        text = stringResource(R.string.input_view_hint),
        style = inputViewTextStyle(Color(0xFFA3ADB5)),
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 18.dp)
    )
}

@Composable
fun pasteButtonColors() =
    ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)

@Composable
fun PasteButtonContainer(pasteButtonContainerModifier: Modifier) {
    Row(
        modifier = pasteButtonContainerModifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(start = 20.dp, top = 9.dp, end = 8.dp, bottom = 9.dp)
                .wrapContentSize(),
            colors = pasteButtonColors()
        ) {
            Text(
                text = stringResource(R.string.paste_button_text),
                style = MaterialTheme.typography.titleSmall,
            )
        }

        Text(
            text = stringResource(R.string.paste_button_hint),
            style = MaterialTheme.typography.displaySmall.copy(
                color = Color(0xFFA3ADB5)
            )
        )
    }
}