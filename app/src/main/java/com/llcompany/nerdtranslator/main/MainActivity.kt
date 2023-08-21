package com.llcompany.nerdtranslator.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rijksdataexplorer.R
import com.llcompany.nerdtranslator.core.NerdTranslatorApp
import com.llcompany.nerdtranslator.main.ui.theme.NerdTranslatorTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setContent {
            MaterialTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                }
            }
        }
    }
}