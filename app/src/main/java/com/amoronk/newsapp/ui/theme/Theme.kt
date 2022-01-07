package com.amoronk.newsapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Color.White,
    onPrimary = Color.White,
    secondary = Black,
    onSecondary = Color.White,
    error = Color.Red,
    background = Color.Black,
    onBackground = Color.White,
    surface = Black,
    onSurface = Color.White


)

private val LightColorPalette = lightColors(
    primary = Purple200,
    primaryVariant = Purple700,
    onPrimary = Black100,
    secondary = Color.White,
    onSecondary = Teal200,
    error = Color.Red,
    onError = Color.Red,
    onBackground = Color.Black,
    onSurface = Black100,
    surface = Color.White,
    background = Gray

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun NewsAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}