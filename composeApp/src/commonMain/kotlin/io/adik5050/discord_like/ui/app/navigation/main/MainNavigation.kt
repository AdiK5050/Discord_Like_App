package io.adik5050.discord_like.ui.app.navigation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowSizeClass.Companion.HEIGHT_DP_MEDIUM_LOWER_BOUND
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_MEDIUM_LOWER_BOUND
import io.adik5050.discord_like.shared.composables.BottomNavigation
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.UserSession
import io.adik5050.discord_like.ui.app.home_page.HomePage
import io.adik5050.discord_like.ui.app.home_page.composables.CompactHomePageBar
import io.adik5050.discord_like.ui.app.home_page.composables.WideHomePageBar
import io.adik5050.discord_like.ui.app.navigation.Route
import io.adik5050.discord_like.ui.app.profile.ProfilePage
import io.adik5050.discord_like.ui.app.profile.viewmodels.ProfileViewModel

@Composable
fun MainNavigation(
    modifier: Modifier = Modifier,
    appDatabase: AppDatabase,
    userSession: UserSession,
    profileViewModel: ProfileViewModel,
    windowSizeClass: WindowSizeClass,
    onNavigateToChat: (Int) -> Unit,
    onNavigateToEditProfile: () -> Unit,
    onNavigateToWelcome: () -> Unit,
    onNavigateToCreateChannel: () -> Unit,
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
            .windowInsetsPadding(WindowInsets.statusBars)
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
                                onNavigateToCreateChannel = onNavigateToCreateChannel
                            )
                        }
                        entry<Route.Profile> {
                            ProfilePage(
                                profileViewModel = profileViewModel,
                                onNavigateBack = navigator::goBack,
                                onNavigateToEditProfile = onNavigateToEditProfile,
                                onNavigateToWelcome = onNavigateToWelcome
                            )
                        }
                        entry<Route.Settings> {
                            ProfilePage(
                                profileViewModel = profileViewModel,
                                onNavigateBack = navigator::goBack,
                                onNavigateToEditProfile = {
                                    onNavigateToEditProfile()
                                },
                                onNavigateToWelcome = {
                                    onNavigateToWelcome()
                                }
                            )
                        }
                    }
                )
            )

            if(!windowSizeClass.isWidthAtLeastBreakpoint(WIDTH_DP_MEDIUM_LOWER_BOUND)) {
                BottomNavigation(
                    modifier = Modifier
                        .padding(8.dp),
                    image = profileViewModel.userProfileImage,
                    selectedKey = navigationState.topLevelRoute,
                    onSelectedKey =  navigator::navigate
                )
            }
            else if(!windowSizeClass.isHeightAtLeastBreakpoint(HEIGHT_DP_MEDIUM_LOWER_BOUND)) {
                CompactHomePageBar(
                    modifier = Modifier
                        .padding(8.dp),
                    username = profileViewModel.username,
                    displayName = profileViewModel.displayName,
                    image = profileViewModel.userProfileImage,
                    onClickProfile = {
                        navigator.navigate(Route.Profile)
                    }
                )
            }
            else {
                WideHomePageBar(
                    modifier = Modifier
                        .padding(8.dp),
                    username = profileViewModel.username,
                    displayName = profileViewModel.displayName,
                    image = profileViewModel.userProfileImage,
                    onClickProfile = {
                        navigator.navigate(Route.Profile)
                    }
                )
            }
        }
    }
}