package io.adik5050.discord_like

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fitInside
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.WindowInsetsRulers
import com.wannaverse.imageselector.registerImageSelectorLauncher
import com.wannaverse.imageselector.setImageSelectorActivity
import io.adik5050.discord_like.storage.getDatabase
import io.adik5050.discord_like.ui.app.App

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setImageSelectorActivity(this)
        registerImageSelectorLauncher()
        setContent {
            val appDatabase = getDatabase(this)
            App(
                appDatabase = appDatabase,
            )
        }
    }
}