package io.adik5050.discord_like.ui.app.navigation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.scene.Scene

class HomePageSceneForWideScreen<T: Any>(
    val homePage: NavEntry<T>,
    val chatPage: NavEntry<T>,
    override val key: Any,
    override val previousEntries: List<NavEntry<T>>
): Scene<T> {
    override val entries: List<NavEntry<T>>
        get() = listOf(homePage,chatPage)

    override val content: @Composable (() -> Unit) = {
        Row (
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.weight(3f)
            ) {
                homePage.Content()
            }
            Column(
                modifier = Modifier.weight(7f)
            ) {
                chatPage.Content()
            }
        }
    }
    companion object {
        const val `HOME-PAGE_KEY` = "HomePageSceneForWideScreen-HomePage"
        const val `CHAT-PAGE_KEY` = "HomePageSceneForWideScreen-ChatPage"

        fun homePagePane() = mapOf(`HOME-PAGE_KEY` to true)
        fun chatPagePane() = mapOf(`CHAT-PAGE_KEY` to true)
    }
}
