package com.example.financial_advice.app.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

val DarkColorScheme = darkColorScheme(
        primary = Blue,
        secondary = Green,
        tertiary = Green,
        background = Green,
)

val LightColorScheme = lightColorScheme(
        primary = Blue,
        secondary = Green,
        tertiary = Green,
        background = Blue,

        /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun Financial_AdviceTheme(
//        darkTheme: Boolean = isSystemInDarkTheme(),
//        Dynamic color is available on Android 12+
//        dynamicColor: Boolean = true,

        content: @Composable () -> Unit
) {
//    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme
//        }
    MaterialTheme(
            colorScheme = LightColorScheme,
            typography = Typography,
            content = content
    )
}