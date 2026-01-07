package io.adik5050.discord_like

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.adik5050.discord_like.ui.app.App
import io.adik5050.discord_like.ui.app.WindowSizes

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            val currentWindowSize = calculateWindowSizeClass(this)
            val windowSize = when (currentWindowSize.widthSizeClass) {
                WindowWidthSizeClass.Compact -> WindowSizes.COMPACT
                WindowWidthSizeClass.Medium -> WindowSizes.MEDIUM
                WindowWidthSizeClass.Expanded -> WindowSizes.LARGE
                else -> WindowSizes.MEDIUM
            }
            App(
                windowSize
            )
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}