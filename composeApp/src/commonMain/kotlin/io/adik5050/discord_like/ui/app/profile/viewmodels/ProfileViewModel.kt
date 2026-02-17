package io.adik5050.discord_like.ui.app.profile.viewmodels

import androidx.lifecycle.ViewModel
import io.adik5050.discord_like.storage.UserSession

class ProfileViewModel (
    val userSession: UserSession
): ViewModel() {
    val userId = userSession.getUserId()
    val username = userSession.getUsername()
    val displayName = userSession.getDisplayName()
    val pronouns = userSession.getPronouns()
    var userProfileImage: ByteArray? = null

    init {
        userProfileImage = userSession.getUserProfileImage()
    }
}