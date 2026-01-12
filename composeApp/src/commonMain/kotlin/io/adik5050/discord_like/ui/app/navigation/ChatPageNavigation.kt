package io.adik5050.discord_like.ui.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.ui.app.chat.Chat
import io.adik5050.discord_like.ui.app.chat_info.ChatInfo
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun ChatPageNavigation(
    modifier: Modifier = Modifier,
    appDatabase: AppDatabase
) {
    val chatPageBackStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(Route.ChatPage.Chat::class, Route.ChatPage.Chat.serializer())
                    subclass(Route.ChatPage.ChatInfo::class, Route.ChatPage.ChatInfo.serializer())
                }
            }
        },
        Route.ChatPage
    )
    NavDisplay(
        modifier = modifier,
        backStack = chatPageBackStack,
        entryProvider = entryProvider {
            entry<Route.ChatPage.Chat> {
                Chat(
                    modifier = Modifier,
                    appDatabase = appDatabase,
                )
            }
            entry<Route.ChatPage.ChatInfo> {
                ChatInfo(
                    modifier = Modifier,
                )
            }
        }
    )

}