package com.llcompany.nerdtranslator.base.main.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.llcompany.nerdtranslator.R

private val defaultLetterSpacing = 0.5.sp

private val interFontFamily = FontFamily(
    Font(R.font.inter_thin, FontWeight.Thin),
    Font(R.font.inter_extra_light, FontWeight.ExtraLight),
    Font(R.font.inter_light, FontWeight.Thin),
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semi_bold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_extra_bold, FontWeight.ExtraBold),
    Font(R.font.inter_black, FontWeight.Black),
)

// Set of Material typography styles to start with
val Typography = Typography(
    // bodyLarge is for short source text
    bodyLarge = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = defaultLetterSpacing
    ),
    // bodyMedium is for long source text
    bodyMedium = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = defaultLetterSpacing
    ),
    // bodySmall is for language selector text
    bodySmall = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        letterSpacing = defaultLetterSpacing
    ),
    // displayLarge is for short destination text
    displayLarge = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = defaultLetterSpacing
    ),
    // displayMedium is for long destination text
    displayMedium = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = defaultLetterSpacing
    ),
    // displaySmall is for "create a tag and use it..." hint under the input view
    displaySmall = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 28.sp,
        letterSpacing = defaultLetterSpacing
    ),
    // titleLarge is for titles of screens (Create a tag, Select tags to duplicate, etc.)
    titleLarge = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = defaultLetterSpacing
    ),
    // titleMedium is for tags (e.g. on "select tags" screen)
    titleMedium = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = defaultLetterSpacing
    ),
    // titleSmall is for filled buttons (e.g. "create", "done", "paste")
    titleSmall = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        letterSpacing = defaultLetterSpacing
    ),
    // labelLarge is for hint labels (e.g. under pre-translate image)
    labelLarge = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = defaultLetterSpacing
    ),
    // labelMedium is for smaller hint labels (e.g. under pre-translate image)
    labelMedium = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        letterSpacing = defaultLetterSpacing
    ),
    // headlineMedium is for dialogs texts
    headlineMedium = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        letterSpacing = defaultLetterSpacing
    ),
    // headlineSmall is for extra small hints (e.g. like "Currently you add to favorites as tag")
    headlineSmall = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        letterSpacing = defaultLetterSpacing
    ),
)