package io.adik5050.discord_like.ui.app.profile.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.UserSession
import kotlinx.coroutines.launch
import kotlin.io.encoding.Base64

class ProfileViewModel (
    appDatabase: AppDatabase,
    val userSession: UserSession
): ViewModel() {
    val userDao = appDatabase.getUserDao()
    val userId = userSession.getUserId()
    val username = userSession.getUsername()
    val displayName = userSession.getDisplayName()
    val pronouns = userSession.getPronouns()
    var userProfileImage: ByteArray? by mutableStateOf(null)

    init {
        viewModelScope.launch {
            userProfileImage = userDao.getUserProfilePic(userId)
        }
    }
}