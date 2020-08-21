package `in`.jitinsharma.mydrivecompose.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color(0xFF4378DB),
    primaryVariant = Color(0xFF405DB5),
    secondary = Color.Black,
    onPrimary = Color.White,
    onSecondary = Color.White,
    background = Color.Black,
    onBackground = Color.White,
    surface = Color.Black,
    onSurface = Color.White
)

private val LightColorPalette = lightColors(
    primary = Color(0xFF4378DB),
    primaryVariant = Color(0xFF405DB5),
    secondary = Color(0xFFF2F5F8),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    surface = Color.White

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
fun MyDriveComposeTheme(
    darkTheme: MutableState<Boolean>,
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme.value) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}