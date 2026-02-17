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
        private  const val KEY_USERNAME = "user_username"
        private const val KEY_PASSWORD = "user_password"
        private const val KEY_USER_ID = "user_id"
        private const val KEY_USER_PROFILE_IMAGE = "user_profile_image"
        private const val KEY_DISPLAY_NAME = "user_display_name"
        private const val KEY_PRONOUNS = "user_pronouns"
        private const val KEY_LOGGED_IN = "user_logged_in"
    }

    fun getUserId(): Int {
        return settings.getInt(KEY_USER_ID, defaultValue = 0)
    }
    fun getUsername(): String {
        return settings.getString(KEY_USERNAME, defaultValue = "")
    }
    fun getPassword(): String {
        return settings.getString(KEY_PASSWORD, defaultValue = "")
    }
    fun setDisplayName(displayName: String) {
        if(displayName.trim().isNotEmpty()) settings.putString(KEY_DISPLAY_NAME, displayName)
    }
    fun getDisplayName(): String {
        return settings.getString(KEY_DISPLAY_NAME, defaultValue = "")
    }
    fun setPronouns(pronouns: String) {
        if(pronouns.trim().isNotEmpty()) settings.putString(KEY_PRONOUNS, pronouns)
    }
    fun getPronouns(): String? {
        val pronouns = settings.getString(KEY_PRONOUNS, defaultValue = "")
        return pronouns.trim().ifEmpty { null }
    }
    fun saveUserProfileImage(userProfileImage: ByteArray) {
        settings.putString(KEY_USER_PROFILE_IMAGE,userProfileImage.toString())
    }
    fun getUserProfileImage() : ByteArray? {
        val byteArrayString = settings.getString(KEY_USER_PROFILE_IMAGE, defaultValue = "")
        if(byteArrayString.isNotBlank())
            return byteArrayString.encodeToByteArray()
        else
            println("User Profile Image is not present.")
        return null
    }
    fun isLoggedIn(): Boolean {
        return settings.getBoolean(KEY_LOGGED_IN, defaultValue = false)
    }

    fun saveUserSession(username: String, password: String, userID: Int, displayName: String) {
        settings.putString(KEY_USERNAME, username)
        settings.putString(KEY_PASSWORD, password)
        settings.putInt(KEY_USER_ID, userID)
        settings.putString(KEY_DISPLAY_NAME, displayName)
        settings.putBoolean(KEY_LOGGED_IN, true)
    }
    fun clearUserSession() {
        settings.remove(KEY_USERNAME)
        settings.remove(KEY_PASSWORD)
        settings.remove(KEY_USER_ID)
        settings.remove(KEY_USER_PROFILE_IMAGE)
        settings.remove(KEY_PRONOUNS)
        settings.remove(KEY_DISPLAY_NAME)
        settings.putBoolean(KEY_LOGGED_IN, false)
    }
}