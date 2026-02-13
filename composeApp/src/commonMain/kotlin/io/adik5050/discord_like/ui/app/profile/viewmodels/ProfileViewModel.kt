package io.adik5050.discord_like.ui.app.profile.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wannaverse.imageselector.ImageData
import com.wannaverse.imageselector.selectImage
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.UserSession
import kotlinx.coroutines.launch

class ProfileViewModel (
    appDatabase: AppDatabase,
    val userSession: UserSession
): ViewModel() {
    val userId = userSession.getUserId()
    val userName = userSession.getUsername()
    var userProfileImage: ByteArray? = null;

    val image = mutableStateOf<ImageData?>(null)

    init {
        userProfileImage = userSession.getUserProfileImage()
    }



    fun chooseImage() = viewModelScope.launch {
        image.value = selectImage()
        if(image.value != null) {
            userSession.saveUserProfileImage(image.value?.bytes!!)
        }
    }
}