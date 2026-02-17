package io.adik5050.discord_like.ui.app.navigation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fitInside
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.WindowInsetsRulers
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowSizeClass.Companion.HEIGHT_DP_MEDIUM_LOWER_BOUND
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_MEDIUM_LOWER_BOUND
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.UserSession
import io.adik5050.discord_like.ui.app.home_page.HomePage
import io.adik5050.discord_like.ui.app.home_page.composables.CompactHomePageBar
import io.adik5050.discord_like.ui.app.home_page.composables.WideHomePageBar
import io.adik5050.discord_like.ui.app.navigation.Route
import io.adik5050.discord_like.ui.app.profile.ProfilePage

@Composable
fun MainNavigation(
    modifier: Modifier = Modifier,
    appDatabase: AppDatabase,
    userSession: UserSession,
    windowSizeClass: WindowSizeClass,
    onNavigateToChat: () -> Unit,
    onNavigateToEditProfile: () -> Unit,
    onNavigateToWelcome: () -> Unit,
) {
    val navigationState = rememberMainBottomNavigationState(
        startRoute = Route.Home,
        topLevelRoutes = TOP_LEVEL_DESTINATIONS.keys
    )
    val navigator = remember {
        MainNavigator(navigationState)
    }
    Surface (
        modifier = modifier
            .fitInside(WindowInsetsRulers.SafeDrawing.current)
            .fillMaxSize(),
    ) {
        Column {
            NavDisplay(
                modifier = Modifier
                    .weight(8f),
                onBack = navigator::goBack,
                entries = navigationState.toEntries(
                    entryProvider {
                        entry<Route.Home> {
                            HomePage(
                                appDatabase = appDatabase,
                                userSession = userSession,
                                onClickMessageIcon = {
                                    navigator.navigate(Route.Home)
                                },
                                onClickChatPage = onNavigateToChat,
                            )
                        }
                        entry<Route.Profile> {
                            ProfilePage(
                                userSession = userSession,
                                onNavigateBack = navigator::goBack,
                                onNavigateToEditProfile = onNavigateToEditProfile,
                                onNavigateToWelcome = onNavigateToWelcome
                            )
                        }
                        entry<Route.Settings> {
                            ProfilePage(
                                userSession = userSession,
                                onNavigateBack = navigator::goBack,
                                onNavigateToEditProfile = onNavigateToEditProfile,
                                onNavigateToWelcome = onNavigateToWelcome
                            )
                        }
                    }
                )
            )
            if(!windowSizeClass.isWidthAtLeastBreakpoint(WIDTH_DP_MEDIUM_LOWER_BOUND)) {
                MainBottomNavigationBar(
                    modifier = Modifier
                        .fillMaxWidth(),
                    selectedKey = navigationState.topLevelRoute,
                    onSelectKey = navigator::navigate,
                )
            }
            else if(!windowSizeClass.isHeightAtLeastBreakpoint(HEIGHT_DP_MEDIUM_LOWER_BOUND)) {
                CompactHomePageBar(
                    modifier = Modifier
                        .padding(8.dp),
                    onClickProfile = {
                        navigator.navigate(Route.Profile)
                    }
                )
            }
            else {
                WideHomePageBar(
                    modifier = Modifier
                        .padding(8.dp),
                    onClickProfile = {
                        navigator.navigate(Route.Profile)
                    }
                )
            }
        }
    }
}