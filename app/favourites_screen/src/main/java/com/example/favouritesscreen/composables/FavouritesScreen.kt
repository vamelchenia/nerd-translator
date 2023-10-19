package com.example.favouritesscreen.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.createtagsheet.CreateTagSheetViewModel
import com.example.createtagsheet.composables.CreateTagSheet
import com.example.favouritesscreen.FavouritesScreenContract
import kotlinx.coroutines.flow.Flow

private val bottomSheetMargins = PaddingValues(top = 70.dp)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouritesScreen(
    state: FavouritesScreenContract.State,
    effectFlow: Flow<FavouritesScreenContract.Effect>?,
    onEventSent: (event: FavouritesScreenContract.Event) -> Unit,
    createTagSheetViewModel: CreateTagSheetViewModel
) {
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(true)

    val onShowBottomSheetChanged: (Boolean) -> Unit = { value ->
        showBottomSheet = value
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
    ) { contentPadding ->
        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState,
                modifier = Modifier
                    .padding(bottomSheetMargins)
            ) {
                val createTagSheetViewModelState = createTagSheetViewModel.getState().value
                if ((createTagSheetViewModelState.isValid)
                    && (createTagSheetViewModelState.isCreated)
                ) {
                    showBottomSheet = false
                    createTagSheetViewModel.switchIsValid(false)
                }
                if (showBottomSheet) {
                    createTagSheetViewModel.updateContentPaddingBottomSheet(contentPadding)
                    CreateTagSheet(createTagSheetViewModel)
                }
            }
        } else {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                FavouritesScreenImage()
                CreateButton(onShowBottomSheetChanged)
            }
        }
    }
}