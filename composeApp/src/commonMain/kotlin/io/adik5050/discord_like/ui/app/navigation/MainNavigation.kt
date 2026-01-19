package io.adik5050.discord_like.ui.app.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_MEDIUM_LOWER_BOUND
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.ui.app.profile.PersonalProfilePage

@Composable
fun MainNavigation(
    modifier: Modifier = Modifier,
    appDatabase: AppDatabase
) {
    val navigationState = rememberMainBottomNavigationState(
        startRoute = Route.Home,
        topLevelRoutes = TOP_LEVEL_DESTINATIONS.keys
    )
    val navigator = remember {
        MainNavigator(navigationState)
    }
    var showMainBottomNavigationBar by remember { mutableStateOf(true) }
    var nestedBackStacks: NavBackStack<NavKey>? by remember { mutableStateOf(null) }
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    Surface (
        modifier = modifier
            .padding(top = 8.dp),
    ) {
        Column {
            NavDisplay(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(9f),
                onBack = navigator::goBack,
                entries = navigationState.toEntries(
                    entryProvider {
                        entry<Route.Home>{
                            HomeNavigation(
                                modifier = Modifier,
                                appDatabase = appDatabase,
                                showMainBottomNavigationBar = {
                                    showMainBottomNavigationBar = true
                                },
                                hideMainBottomNavigationBar = {
                                    showMainBottomNavigationBar = false
                                },
                                getHomeBackstack = { homeBackStack ->
                                    nestedBackStacks = homeBackStack
                                },
                                windowSizeClass = windowSizeClass
                            )
                        }
                        entry<Route.Profile> {
                            PersonalProfilePage()
                        }
                        entry<Route.Settings> {
                            PersonalProfilePage()
                        }
                    }
                )
            )

            if(!windowSizeClass.isWidthAtLeastBreakpoint(WIDTH_DP_MEDIUM_LOWER_BOUND)) {
                if(nestedBackStacks?.lastOrNull() == Route.Home.HomePage) {
                    MainBottomNavigationBar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.8f),
                        selectedKey = navigationState.topLevelRoute,
                        onSelectKey = {
                            navigator.navigate(it)
                        },
                    )
                }
            }
        }
    }
}