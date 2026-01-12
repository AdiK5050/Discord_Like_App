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

//        val currentWindowSize = LocalWindowInfo.current.containerSize.width.dp
//        val windowSize: WindowSizes =
//            if(currentWindowSize < 800.dp) WindowSizes.COMPACT
//            else if(currentWindowSize > 1600.dp) WindowSizes.LARGE
//            else WindowSizes.MEDIUM