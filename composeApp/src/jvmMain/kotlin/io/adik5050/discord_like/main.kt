package io.adik5050.discord_like

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.adik5050.discord_like.storage.getDatabase
import io.adik5050.discord_like.ui.app.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "MyApplication",
    ) {
        val appDatabase = getDatabase()
        App(
            appDatabase
        )
    }
}
