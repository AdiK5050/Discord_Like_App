package io.adik5050.discord_like.ui.app.navigation.chat

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.ui.app.chat.ChatPage
import io.adik5050.discord_like.ui.app.chat_info.ChatInfo
import io.adik5050.discord_like.ui.app.navigation.Route
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun ChatNavigation(
    modifier: Modifier = Modifier,
    appDatabase: AppDatabase,
    onNavigateToHome: () -> Unit
) {
    val chatPageBackStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(Route.Chat.ChatPage::class, Route.Chat.ChatPage.serializer())
                    subclass(Route.Chat.ChatInfo::class, Route.Chat.ChatInfo.serializer())
                }
            }
        },
        Route.Chat.ChatPage
    )
    NavDisplay(
        modifier = modifier,
        backStack = chatPageBackStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Route.Chat.ChatPage> {
                ChatPage(
                    modifier = Modifier,
                    appDatabase = appDatabase,
                    onNavigateToHome = {
                        onNavigateToHome()
                    }
                )
            }
            entry<Route.Chat.ChatInfo> {
                ChatInfo(
                    modifier = Modifier,
                )
            }
        }
    )
}