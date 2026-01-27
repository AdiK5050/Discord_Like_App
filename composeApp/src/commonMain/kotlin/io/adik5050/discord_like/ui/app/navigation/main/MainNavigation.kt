package io.adik5050.discord_like.ui.app.navigation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_MEDIUM_LOWER_BOUND
import io.adik5050.discord_like.shared.composables.ErrorPage
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.ui.app.home_page.HomePage
import io.adik5050.discord_like.ui.app.navigation.Route
import io.adik5050.discord_like.ui.app.profile.PersonalProfilePage

@Composable
fun MainNavigation(
    modifier: Modifier = Modifier,
    appDatabase: AppDatabase,
    windowSizeClass: WindowSizeClass,
    onNavigateToChat: () -> Unit
) {
    val navigationState = rememberMainBottomNavigationState(
        startRoute = Route.Home,
        topLevelRoutes = TOP_LEVEL_DESTINATIONS.keys
    )
    val navigator = remember {
        MainNavigator(navigationState)
    }
    Surface (
        modifier = modifier,
    ) {
        Column {
            NavDisplay(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(8f),
                onBack = navigator::goBack,
                entries = navigationState.toEntries(
                    entryProvider {
                        entry<Route.Home> {
                            HomePage(
                                onClickMessageIcon = {
                                    navigator.navigate(Route.Home)
                                },
                                onClickChatPage = onNavigateToChat
                            )
                        }
                        entry<Route.Profile> {
                            PersonalProfilePage()
                        }
                        entry<Route.Settings> {
                            PersonalProfilePage()
                        }
                        entry<Route.Error> {
                            ErrorPage(
                                errorMessage = "",
                                onGoBackToLastDestination = {
                                    navigationState.stackInUse.dropLast(1)
                                }
                            )
                        }
                    }
                )
            )

        if(!windowSizeClass.isWidthAtLeastBreakpoint(WIDTH_DP_MEDIUM_LOWER_BOUND)) {
                MainBottomNavigationBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    selectedKey = navigationState.topLevelRoute,
                    onSelectKey = {
                        navigator.navigate(it)
                    },
                )
            }
        }
    }
}