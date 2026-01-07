package io.adik5050.discord_like.ui.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import io.adik5050.discord_like.ui.app.WindowSizes
import io.adik5050.discord_like.ui.app.chat_page.ChatPage
import io.adik5050.discord_like.ui.app.chat_page.composables.Chat
import io.adik5050.discord_like.ui.app.chat_page.composables.ChatInfo
import io.adik5050.discord_like.ui.app.chat_page.composables.ChatList
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    windowSize: WindowSizes
) {
    val backStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(Route.ChatPage::class, Route.ChatPage.serializer())
                    subclass(Route.Chat::class, Route.Chat.serializer())
                    subclass(Route.ChatInfo::class, Route.ChatInfo.serializer())
                }
            }
        },
        Route.ChatPage
    )

    NavDisplay(
        backStack = backStack,
        entryProvider = { key ->
            when(key) {
                is Route.ChatPage -> {
                    NavEntry(key) {
                        ChatPage(
                            windowSize,
                            modifier,
                            onClick = {
                                backStack.add(Route.Chat(1))
                            }
                        )
                    }
                }
                is Route.Chat -> {
                    NavEntry(key) {
                        Chat()
                    }
                }
                is Route.ChatInfo -> {
                    NavEntry(key) {
                        ChatInfo()
                    }
                }
                else -> error("Unknown key: $key")
            }
        }
    )
}