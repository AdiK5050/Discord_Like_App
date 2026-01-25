package io.adik5050.discord_like.ui.app.navigation.root

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
import io.adik5050.discord_like.ui.app.navigation.Route
import io.adik5050.discord_like.ui.app.navigation.main.MainNavigation
import io.adik5050.discord_like.ui.app.navigation.welcome.WelcomeNavigation
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun RootNavigation(
    modifier: Modifier = Modifier,
    appDatabase: AppDatabase
) {
    val rootBackstack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey:: class) {
                    subclass(Route.Home::class, Route.Home.serializer())
                    subclass(Route.Welcome::class, Route.Welcome.serializer())
                }
            }
        },
        Route.Welcome
    )

    NavDisplay(
        modifier = modifier,
        backStack = rootBackstack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry(Route.Home) {
                MainNavigation(
                    appDatabase = appDatabase
                )
            }
            entry(Route.Welcome) {
                WelcomeNavigation(
                    modifier = modifier,
                    appDatabase = appDatabase,
                    onNavigateToMainNavigation = {
                        rootBackstack.add(Route.Home)
                    }
                )
            }
        }
    )
}