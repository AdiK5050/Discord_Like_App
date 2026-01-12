package io.adik5050.discord_like.ui.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import io.adik5050.discord_like.ui.app.chat_list.ChatList
import io.adik5050.discord_like.ui.app.server_list.ServerList
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun HomePageNavigation(
    modifier: Modifier = Modifier
) {
    val homePageBackStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey:: class) {
                    subclass(Route.HomePage.ChatList::class, Route.HomePage.ChatList.serializer())
                    subclass(Route.HomePage.ServerList::class, Route.HomePage.ServerList.serializer())
                }
            }
        },
        Route.HomePage.ChatList
    )
    NavDisplay(
        modifier = modifier,
        backStack = homePageBackStack,
        entryProvider = entryProvider {
            entry<Route.HomePage.ChatList> {
                ChatList()
            }
            entry<Route.HomePage.ServerList> {
                ServerList(
                    modifier = Modifier,
                    {}
                )
            }
        }
    )
}
