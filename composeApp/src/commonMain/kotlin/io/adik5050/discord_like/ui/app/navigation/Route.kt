package io.adik5050.discord_like.ui.app.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route : NavKey {

    @Serializable
    data object Home: Route {
        @Serializable
        data object HomePage: Route

        @Serializable
        data object Chat: Route {

            @Serializable
            data object ChatPage: Route

            @Serializable
            data class ChatInfo( val channelId: Int): Route
        }
    }

    @Serializable
    data object Profile: Route {
        @Serializable
        data object ProfilePage
    }

    @Serializable
    data object Settings: Route

}