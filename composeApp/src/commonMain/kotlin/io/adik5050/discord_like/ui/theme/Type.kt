package io.adik5050.discord_like.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.archivo_black
import myapplication.composeapp.generated.resources.archivo_bold
import myapplication.composeapp.generated.resources.archivo_extra_bold
import myapplication.composeapp.generated.resources.archivo_light
import myapplication.composeapp.generated.resources.archivo_medium
import org.jetbrains.compose.resources.Font

@Composable
fun ArchivoFontFamily() = FontFamily(
    Font(Res.font.archivo_black, weight = FontWeight.Black),
    Font(Res.font.archivo_medium, weight = FontWeight.Normal),
    Font(Res.font.archivo_medium, weight = FontWeight.Medium),
    Font(Res.font.archivo_bold, weight = FontWeight.Bold),
    Font(Res.font.archivo_light, weight = FontWeight.Light),
)

@Composable
fun AppTypography() = Typography().run {
    val fontFamily = ArchivoFontFamily()
    copy(
        displayLarge = displayLarge.copy(fontFamily = fontFamily),
        displayMedium = displayMedium.copy(fontFamily = fontFamily),
        displaySmall = displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = titleLarge.copy(fontFamily = fontFamily),
        titleMedium = titleMedium.copy(fontFamily = fontFamily),
        titleSmall = titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = bodyLarge.copy(fontFamily = fontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = bodySmall.copy(fontFamily = fontFamily),
        labelLarge = labelLarge.copy(fontFamily = fontFamily),
        labelMedium = labelMedium.copy(fontFamily = fontFamily),
        labelSmall = labelSmall.copy(fontFamily = fontFamily)
    )
}