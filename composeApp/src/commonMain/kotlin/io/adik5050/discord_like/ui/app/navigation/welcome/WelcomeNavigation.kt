package io.adik5050.discord_like.ui.app.navigation.welcome

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
import io.adik5050.discord_like.ui.app.login.LoginPage
import io.adik5050.discord_like.ui.app.navigation.Route
import io.adik5050.discord_like.ui.app.navigation.main.MainNavigation
import io.adik5050.discord_like.ui.app.welcome.WelcomePage
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun WelcomeNavigation(
    modifier: Modifier = Modifier,
    appDatabase: AppDatabase,
    onNavigateToMainNavigation: () -> Unit,
) {
    val welcomeBackstack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey:: class) {
                    subclass(Route.Welcome.WelcomePage::class, Route.Welcome.WelcomePage.serializer())
                    subclass(Route.Welcome.Login::class, Route.Welcome.Login.serializer())
                    subclass(Route.Welcome.Register::class, Route.Welcome.Register.serializer())
                }
            }
        },
        Route.Welcome.WelcomePage
    )
    NavDisplay(
        modifier = modifier,
        backStack = welcomeBackstack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Route.Welcome.WelcomePage> {
                WelcomePage(
                    onClickToLogin = {
                        welcomeBackstack.add(Route.Welcome.Login)
                    },
                    onClickToRegister = {}
                )
            }
            entry(Route.Welcome.Login) {
                LoginPage(
                    appDatabase = appDatabase,
                    onNavigateToMainPage = onNavigateToMainNavigation
                )
            }
            entry(Route.Welcome.Register) {

            }
        }
    )
}