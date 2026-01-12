package io.adik5050.discord_like.ui.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import io.adik5050.discord_like.storage.AppDatabase
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun MainNavigation(
    modifier: Modifier = Modifier,
    appDatabase: AppDatabase
) {
    val rootBackStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey:: class) {
                    subclass(Route.ChatPage::class, Route.ChatPage.serializer())
                    subclass(Route.HomePage::class, Route.HomePage.serializer())
                }
            }
        },
        Route.HomePage
    )
    NavDisplay(
        modifier = modifier,
        backStack = rootBackStack,
        entryProvider = entryProvider {
            entry<Route.HomePage> {
                HomePageNavigation(
                    modifier = Modifier,
                    )
            }
            entry<Route.ChatPage> {
                ChatPageNavigation(
                    modifier = Modifier,
                    appDatabase= appDatabase
                )
            }
        }
    )
}