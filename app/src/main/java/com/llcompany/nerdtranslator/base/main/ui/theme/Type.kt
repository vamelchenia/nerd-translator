package com.llcompany.nerdtranslator.base.main.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val interFont = Font(com.example.mainscreen.R.font.inter_black)
private val defaultLetterSpacing = 0.5.sp

// Set of Material typography styles to start with
val Typography = Typography(
    // bodyLarge style is for short source text
    bodyLarge = TextStyle(
        fontFamily = FontFamily(interFont),
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = defaultLetterSpacing
    ),
    // bodyMedium is for long source text
    bodyMedium = TextStyle(
        fontFamily = FontFamily(interFont),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = defaultLetterSpacing
    ),
    // headlineLarge style is for titles of screens (Create a tag, Select tags to duplicate, etc.)
    headlineLarge = TextStyle(
        fontFamily = FontFamily(interFont),
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = defaultLetterSpacing
    )
)