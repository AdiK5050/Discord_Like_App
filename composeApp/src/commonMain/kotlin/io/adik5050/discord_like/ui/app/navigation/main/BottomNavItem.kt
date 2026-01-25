package io.adik5050.discord_like.ui.app.navigation.main

import io.adik5050.discord_like.ui.app.navigation.Route
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.bottom_navigation_home
import myapplication.composeapp.generated.resources.bottom_navigation_profile
import myapplication.composeapp.generated.resources.bottom_navigation_setting
import myapplication.composeapp.generated.resources.discord_home
import myapplication.composeapp.generated.resources.discord_logo
import myapplication.composeapp.generated.resources.discord_settings
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

data class BottomNavItem(
    val icon: DrawableResource,
    val title: StringResource,
)

val TOP_LEVEL_DESTINATIONS = mapOf(
    Route.Home to BottomNavItem(
        icon = Res.drawable.discord_home,
        title = Res.string.bottom_navigation_home
    ),
    Route.Profile to BottomNavItem(
        icon = Res.drawable.discord_logo,
        title = Res.string.bottom_navigation_profile,
    ),
    Route.Settings to BottomNavItem(
        icon = Res.drawable.discord_settings,
        title = Res.string.bottom_navigation_setting
    )
)
