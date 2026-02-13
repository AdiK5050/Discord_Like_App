package io.adik5050.discord_like

import androidx.compose.foundation.layout.fitInside
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.WindowInsetsRulers
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.adik5050.discord_like.storage.getDatabase
import io.adik5050.discord_like.ui.app.App
import java.awt.Dimension

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "MyApplication",
    ) {
        window.minimumSize = Dimension(1200,800)
        val appDatabase = getDatabase()

        App(
            appDatabase = appDatabase
        )
    }
}
