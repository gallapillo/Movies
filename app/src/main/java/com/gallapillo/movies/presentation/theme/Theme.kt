package com.gallapillo.movies.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Primary,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = BackGround
)

@Composable
fun MoviesTheme(content: @Composable() () -> Unit) {

    rememberSystemUiController().setSystemBarsColor(
        color = BackGround,
        darkIcons = false
    )


    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}