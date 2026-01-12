package io.adik5050.discord_like.ui.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun ChatPageNavigation(
    modifier: Modifier = Modifier
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
}