package io.adik5050.discord_like.ui.app.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route : NavKey {

    @Serializable
    data object Welcome: Route {
        @Serializable
        data object WelcomePage: Route
        @Serializable
        data object Login: Route
        @Serializable
        data object Register: Route
    }
    @Serializable
    data object Home: Route

    @Serializable
    data object Profile: Route

    @Serializable
    data object Settings: Route


    @Serializable
    data object Chat: Route {

        @Serializable
        data object ChatPage: Route
        @Serializable
        data class ChatInfo( val channelId: Int): Route
    }

    @Serializable
    data object Error: Route
}