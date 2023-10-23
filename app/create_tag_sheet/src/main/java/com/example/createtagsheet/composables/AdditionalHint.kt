package com.example.createtagsheet.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.createtagsheet.R

private val layoutMargins = PaddingValues(bottom = 18.dp)

@Composable
private fun textStyle(textColor: Color = MaterialTheme.colorScheme.tertiary) =
    MaterialTheme.typography.titleMedium.copy(
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        color = textColor,
    )

@Composable
fun AdditionalHint() {

    ConstraintLayout(
        modifier = Modifier
            .padding(layoutMargins)
    ) {
        Text(
            modifier = Modifier
                .width(320.dp)
                .height(30.dp),
            text = stringResource(R.string.additional_hint),
            style = textStyle()
        )
    }
}

