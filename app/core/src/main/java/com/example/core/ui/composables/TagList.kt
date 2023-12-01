package com.example.core.ui.composables

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.ui.data.TagInformation
import com.example.core.ui.data.TagListState
import java.util.Date
import java.util.LinkedList

private val containerMargins = PaddingValues(9.dp, 0.dp, 10.dp, 72.dp)
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TagList(
    state: TagListState
) {
    FlowRow (
        modifier = Modifier
            .padding(containerMargins)
            .fillMaxWidth()
    ) {
       state.tagsInformation.forEach {
               tagInfo -> Tag(
                    tagInfo.tagName,
                    tagInfo.tagCount,
                   false
                    )
       }
    }

}

