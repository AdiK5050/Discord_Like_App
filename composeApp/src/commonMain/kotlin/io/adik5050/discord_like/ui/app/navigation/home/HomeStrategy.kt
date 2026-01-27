package io.adik5050.discord_like.ui.app.navigation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.scene.Scene
import androidx.navigation3.scene.SceneStrategy
import androidx.navigation3.scene.SceneStrategyScope
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_MEDIUM_LOWER_BOUND

class HomePageStrategy<T:Any>(
    val windowSizeClass: WindowSizeClass
): SceneStrategy<T> {
    override fun SceneStrategyScope<T>.calculateScene(entries: List<NavEntry<T>>): Scene<T>? {
        if(windowSizeClass.isWidthAtLeastBreakpoint(WIDTH_DP_MEDIUM_LOWER_BOUND)) {
            val chatPageEntry = entries
                .lastOrNull()
                ?.takeIf {
                    it.metadata.containsKey(HomePageSceneForWideScreen.`CHAT-PAGE_KEY`)
                }
                ?: return null

            val homePageEntry = entries
                .findLast {
                    it.metadata.containsKey(HomePageSceneForWideScreen.`HOME-PAGE_KEY`)
                }
                ?: return null

            return HomePageSceneForWideScreen(
                homePage = homePageEntry,
                chatPage = chatPageEntry,
                key = homePageEntry.contentKey,
                previousEntries = entries.dropLast(1),
            )
        }
        return null
    }
}

@Composable
fun <T: Any> rememberHomePageStrategy(windowSizeClass: WindowSizeClass): HomePageStrategy<T> {
    return remember(windowSizeClass) {
        HomePageStrategy(windowSizeClass)
    }
}