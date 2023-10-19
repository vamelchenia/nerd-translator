package com.example.tagscreen.composables

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private val containerMargins = PaddingValues(9.dp, 0.dp, 10.dp, 72.dp)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TagContainer() {
            FlowRow(
                modifier = Modifier.padding(containerMargins).fillMaxWidth(),
            ) {
                Tag("#Lesson1", "8", false)
                Tag("#Homework", "12", false)
                Tag("ertwsgh","23", false)
                Tag("sdfadgdfghasdfh", "23", true)
                Tag("sdfasf", "23", false)
                Tag("asdfasd", "23", false)
            }



}