package com.llcompany.nerdtranslator.base.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.llcompany.nerdtranslator.base.main.ui.composables.NerdTranslatorAppBar
import com.llcompany.nerdtranslator.base.main.ui.theme.NerdTranslatorTheme
import com.llcompany.nerdtranslator.base.navigation.NavigationHolder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NerdTranslatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Scaffold(
                        containerColor = MaterialTheme.colorScheme.surface,
                        topBar = { NerdTranslatorAppBar() }
                    ) { paddingValues ->
                        NavigationHolder(
                            navHolderModifier = Modifier.padding(paddingValues)
                        )
                    }
                }
            }
        }
    }
}