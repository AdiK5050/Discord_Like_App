package io.adik5050.discord_like

import androidx.compose.ui.window.ComposeUIViewController
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.getDatabase
import io.adik5050.discord_like.ui.app.App

fun MainViewController() = ComposeUIViewController {
    val appDatabase: AppDatabase = getDatabase()
    App(appDatabase
    )
}