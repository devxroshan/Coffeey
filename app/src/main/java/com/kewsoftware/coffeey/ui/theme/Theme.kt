package com.kewsoftware.coffeey.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Brown,
    secondary = LightBrown,
    background = Background,
    tertiaryContainer = TertiaryBackground,
    surface = SecondaryBlack,
    surfaceVariant = TertiaryBlack,
    onSurface = TextPrimary,
    outline = Border
)

@Composable
fun CoffeeyTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}