package io.adik5050.discord_like.ui.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun MainNavigation(
    modifier: Modifier = Modifier,
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
}