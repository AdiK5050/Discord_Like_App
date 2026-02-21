package io.adik5050.discord_like.ui.app.profile.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wannaverse.imageselector.ImageData
import com.wannaverse.imageselector.selectImage
import com.wannaverse.imageselector.toByteArray
import com.wannaverse.imageselector.toImageBitmap
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.UserSession
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch


data class User(
    val userId: Int,
    val username: String,
    val displayName: String,
    val pronouns: String?,
    val thoughts: String?,
    val about: String?,
    val onlineStatus: String,
)

class ProfileViewModel(
    appDatabase: AppDatabase,
    val userSession: UserSession
): ViewModel() {

    val userDao = appDatabase.getUserDao()
    val userId = userSession.getUserId()
    var userInfo by mutableStateOf<User?>(null)
    var username by mutableStateOf("")

    var isInfoChanged by mutableStateOf(false)
    var changesSaved by mutableStateOf(false)
    var displayName by mutableStateOf("")
    var newDisplayName by mutableStateOf(TextFieldValue(""))
        private set

    var pronouns: String? by mutableStateOf(null)
    var newPronouns by mutableStateOf( TextFieldValue(""))
        private set

    var about: String? by mutableStateOf(null)
    var newAbout by mutableStateOf(TextFieldValue(""))
        private set

    var thoughts: String? by mutableStateOf(null)
    var newThoughts by mutableStateOf(TextFieldValue(""))
        private set
    var userProfileImage: ImageBitmap? by mutableStateOf(null)
    var newUserProfileImage: ImageBitmap? by mutableStateOf(null)

    var image by mutableStateOf<ImageData?>(null)

    fun loadUserInfo() = viewModelScope.launch {
        userInfo = userDao.getUserWithUserId(userId)
        userInfo?.let {
            username = it.username
            displayName = it.displayName
            newDisplayName = TextFieldValue(it.displayName)
            it.pronouns?.let { pro ->
                pronouns = pro
                newPronouns = TextFieldValue(pro)
            }
            it.about?.let { abo ->
                about = abo
                newAbout = TextFieldValue(abo)
            }
            it.thoughts?.let { tho ->
                thoughts = tho
                newThoughts = TextFieldValue(tho)
            }
        }
    }
    fun loadImage() = viewModelScope.launch(Dispatchers.IO) {
        userDao.getUserProfilePic(userId)?.let {
            userProfileImage = it.toImageBitmap()
            newUserProfileImage = it.toImageBitmap()
        }
    }

    fun loadResources() = viewModelScope.launch {
        loadUserInfo().join()
        loadImage()
    }
    fun updateDisplayName(newValue: TextFieldValue) {
        newDisplayName = newValue
        hasChanges()
    }
    fun updatePronouns(newValue: TextFieldValue) {
        newPronouns = newValue
        hasChanges()
    }
    fun updateThoughts(newValue: TextFieldValue) {
        newThoughts = newValue
        hasChanges()
    }
    fun updateAbout(newValue: TextFieldValue) {
        newAbout = newValue
        hasChanges()
    }

    fun hasChanges() {
        isInfoChanged = if(
            displayName.trim() != newDisplayName.text.trim() ||
            pronouns?.trim() != newPronouns.text.trim() ||
            thoughts?.trim() != newThoughts.text.trim() ||
            about?.trim() != newAbout.text.trim()
        ) true
        else {
            false
        }
    }
    fun onSave() = viewModelScope.launch {
        userDao.setUserProfileInfo(
            userId = userId,
            displayName = newDisplayName.text.trim().ifEmpty { username },
            pronouns = newPronouns.text.trim(),
            thoughts = newThoughts.text.trim(),
            about = newAbout.text.trim(),
            profileImage = newUserProfileImage?.toByteArray())
        userSession.setPronouns(newPronouns.text)
        userSession.setDisplayName(newDisplayName.text)
        changesSaved = true
    }
    fun chooseImage() = viewModelScope.launch {
        image = selectImage()
        if(image != null) {
            newUserProfileImage = image?.bytes?.toImageBitmap()
            isInfoChanged = true
        }
    }
}