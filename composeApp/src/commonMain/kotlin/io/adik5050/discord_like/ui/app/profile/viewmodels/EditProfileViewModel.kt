package io.adik5050.discord_like.ui.app.profile.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wannaverse.imageselector.ImageData
import com.wannaverse.imageselector.selectImage
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.UserSession
import kotlinx.coroutines.launch

class EditProfileViewModel(
    appDatabase: AppDatabase,
    val userSession: UserSession
): ViewModel() {

    val userDao = appDatabase.getUserDao()
    val userId = userSession.getUserId()

    var uiState by mutableStateOf<UserProfileUiState>(UserProfileUiState.Loading)
        private set
    var username by mutableStateOf(userSession.getUsername())
        private set
    var displayName by mutableStateOf(TextFieldValue(userSession.getDisplayName()))
        private set
    var pronouns by mutableStateOf(userSession.getPronouns()?.let { TextFieldValue(it) } ?: TextFieldValue(""))
        private set
    var about by mutableStateOf(userSession.getPronouns()?.let { TextFieldValue(it) } ?: TextFieldValue(""))
        private set

    var userProfileImage: ByteArray? by mutableStateOf( null)
        private set

    val image = mutableStateOf<ImageData?>(null)

    init {
        viewModelScope.launch {
            userProfileImage = userDao.getUserProfilePic(userId)
        }
    }

    fun updateUserProfileImage(image: ByteArray?) {
        if(image != null) {
            userProfileImage = image
        }
    }
    fun updateDisplayName(newValue: TextFieldValue) {
        if(newValue.text.trim().isNotEmpty())  { displayName = newValue }
        else displayName = TextFieldValue(username)
    }
    fun updatePronouns(newValue: TextFieldValue) {
        if(newValue.text.trim().isNotEmpty())  { pronouns = newValue }
        else pronouns = TextFieldValue("")
    }
    fun updateAbout(newValue: TextFieldValue) {
        if(newValue.text.trim().isNotEmpty())  { about = newValue }
        else about = TextFieldValue("")
    }

    fun onSave() = viewModelScope.launch {
        userDao.setUserProfileInfo(userId, displayName.text, pronouns.text, userProfileImage)
        userSession.setPronouns(pronouns.text)
        userSession.setDisplayName(displayName.text)
    }
    fun chooseImage() = viewModelScope.launch {
        image.value = selectImage()
        updateUserProfileImage(image.value?.bytes)
    }
}