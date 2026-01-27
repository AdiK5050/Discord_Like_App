package io.adik5050.discord_like.ui.app.navigation.root

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import io.adik5050.discord_like.shared.composables.ErrorPage
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.ui.app.navigation.Route
import io.adik5050.discord_like.ui.app.navigation.chat.ChatNavigation
import io.adik5050.discord_like.ui.app.navigation.home.HomePageSceneForWideScreen
import io.adik5050.discord_like.ui.app.navigation.home.HomePageStrategy
import io.adik5050.discord_like.ui.app.navigation.home.rememberHomePageStrategy
import io.adik5050.discord_like.ui.app.navigation.main.MainNavigation
import io.adik5050.discord_like.ui.app.navigation.welcome.WelcomeNavigation
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun RootNavigation(
    modifier: Modifier = Modifier,
    appDatabase: AppDatabase
) {
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

    val rootBackstack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey:: class) {
                    subclass(Route.Welcome::class, Route.Welcome.serializer())
                    subclass(Route.Home::class, Route.Home.serializer())
                    subclass(Route.Chat::class, Route.Chat.serializer())
                    subclass(Route.Error::class, Route.Error.serializer())
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
        sceneStrategy = rememberHomePageStrategy(windowSizeClass = windowSizeClass),
        entryProvider = entryProvider {
            entry<Route.Welcome> {
                WelcomeNavigation(
                    modifier = modifier,
                    appDatabase = appDatabase,
                    onNavigateToMainNavigation = {
                        rootBackstack.add(Route.Home)
                    }
                )
            }
            entry<Route.Home>(
                metadata = HomePageSceneForWideScreen.homePagePane()
            ) {
                MainNavigation(
                    appDatabase = appDatabase,
                    windowSizeClass = windowSizeClass,
                    onNavigateToChat = {
                        rootBackstack.add(Route.Chat)
                    }
                )
            }
            entry<Route.Chat>(
                metadata = HomePageSceneForWideScreen.chatPagePane()
            ) {
                ChatNavigation(
                    appDatabase = appDatabase,
                    onNavigateToHome = {
                        rootBackstack.add(Route.Home)
                    }
                )
            }
            entry<Route.Error> {
                ErrorPage(
                    errorMessage = "",
                    onGoBackToLastDestination = {
                        rootBackstack.dropLast(1)
                    }
                )
            }
        }
    )
}