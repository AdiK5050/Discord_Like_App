package io.adik5050.discord_like.ui.app.navigation.home


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import androidx.window.core.layout.WindowSizeClass
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.ui.app.home_page.HomePage
import io.adik5050.discord_like.ui.app.navigation.chat.ChatNavigation
import io.adik5050.discord_like.ui.app.navigation.Route
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun HomeNavigation(
    modifier: Modifier = Modifier,
    appDatabase: AppDatabase,
    getHomeBackstack: (NavBackStack<NavKey>) -> Unit,
    showMainBottomNavigationBar: () -> Unit,
    hideMainBottomNavigationBar: () -> Unit,
    windowSizeClass: WindowSizeClass
) {
    val homeBackStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey:: class) {
                    subclass(Route.Home.HomePage::class, Route.Home.HomePage.serializer())
                    subclass(Route.Home.Chat::class, Route.Home.Chat.serializer())
                }
            }
        },
        Route.Home.HomePage
    )
    getHomeBackstack(homeBackStack)
    if(homeBackStack.last() == Route.Home.HomePage) {
        showMainBottomNavigationBar()
    } else {
        hideMainBottomNavigationBar()
    }
    NavDisplay(
        modifier = modifier,
        backStack = homeBackStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        sceneStrategy = rememberHomePageStrategy(windowSizeClass),
        entryProvider = entryProvider {
            entry<Route.Home.HomePage>(
                metadata = HomePageSceneForWideScreen.homePagePane()
            )  {
                HomePage(
                    modifier = Modifier,
                    onClickMessageIcon = {
                        homeBackStack.dropLast(1)
                        homeBackStack.add(Route.Home.HomePage)
                    },
                    onClickChatPage = {
                        homeBackStack.add(Route.Home.Chat)
                    }
                )
            }
            entry<Route.Home.Chat>(
                metadata = HomePageSceneForWideScreen.chatPagePane()
            )  {
                ChatNavigation(
                    appDatabase = appDatabase,
                    onNavigateToChatList = {
                        homeBackStack.dropLast(n = 1)
                        homeBackStack.add(Route.Home.HomePage)
                    },
                )
            }
        }
    )
}
