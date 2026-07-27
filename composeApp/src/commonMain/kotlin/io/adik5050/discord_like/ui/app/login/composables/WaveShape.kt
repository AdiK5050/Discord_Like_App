package io.adik5050.discord_like.ui.app.login.composables

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class WaveShape: Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val height = size.height
        val width = size.width
        val waveLength = width/8
        val path = Path().apply {
            moveTo(0f, height)
            cubicTo(
                0f,
                -height,
                waveLength,
                height,
                2 * waveLength,
                height)
            cubicTo(
                2 * waveLength,
                -height,
                3 * waveLength,
                height,
                4 * waveLength,
                height)

            cubicTo(
                4 * waveLength,
                -height,
                5 * waveLength,
                height,
                6 * waveLength,
                height)
            cubicTo(
                6 * waveLength,
                -height,
                7 * waveLength,
                height,
                8 * waveLength,
                height)
            close()
        }
        return Outline.Generic(path)
    }
}