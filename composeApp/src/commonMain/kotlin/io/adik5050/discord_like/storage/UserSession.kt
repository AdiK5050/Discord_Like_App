package io.adik5050.discord_like.storage

import com.russhwolf.settings.Settings
import kotlinx.serialization.Serializable
@Serializable
object AppSetting {
    val settings: Settings = Settings()
}

class UserSession() {
    private val settings = AppSetting.settings

    companion object {
        private const val KEY_USER_ID = "user_id"
        private const val KEY_LOGGED_IN = "user_logged_in"
    }

    fun getUserId(): Int {
        return settings.getInt(KEY_USER_ID, defaultValue = 0)
    }

    fun isLoggedIn(): Boolean {
        return settings.getBoolean(KEY_LOGGED_IN, defaultValue = false)
    }

    fun saveUserSession(userID: Int) {
        settings.putInt(KEY_USER_ID, userID)
        settings.putBoolean(KEY_LOGGED_IN, true)
    }
    fun clearUserSession() {
        settings.remove(KEY_USER_ID)
        settings.putBoolean(KEY_LOGGED_IN, false)
    }
}