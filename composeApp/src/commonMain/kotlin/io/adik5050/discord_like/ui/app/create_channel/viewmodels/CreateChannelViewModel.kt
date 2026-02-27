package io.adik5050.discord_like.ui.app.create_channel.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wannaverse.imageselector.toImageBitmap
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.ChannelEntity
import io.adik5050.discord_like.storage.UserSession
import io.adik5050.discord_like.ui.app.chat.viewmodels.UserInfo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class EntityImage (
    val entityId: Int,
    val image: ImageBitmap?
)
class CreateChannelViewModel(
    appDatabase: AppDatabase,
    userSession: UserSession
) : ViewModel() {

    var uiStates: CreateChannelUiStates by mutableStateOf(CreateChannelUiStates.Loading)
        private set
    val userId = userSession.getUserId()
    val userDao = appDatabase.getUserDao()
    val channelDao = appDatabase.getChannelDao()

    var enableButton by mutableStateOf(false)
        private set
    var userInfoList: SnapshotStateList<UserInfo> = mutableStateListOf()
        private set
    var userProfileImages: SnapshotStateList<EntityImage> = mutableStateListOf()
        private set
    var channelMembersList: SnapshotStateList<Int> = mutableStateListOf(userId)
        private set

    var isError by mutableStateOf(false)
    var error by mutableStateOf("")
        private set

    var channelName by mutableStateOf(TextFieldValue(""))
        private set

    var newChannelId: Int? by mutableStateOf(null)
        private set

    init {
        viewModelScope.launch {
            loadUserInfo().join()
            loadProfileImages()
        }
    }

    fun showLoader() {
        uiStates = CreateChannelUiStates.Loading
    }
    suspend fun hideLoader() {
        delay(1000)
        uiStates = CreateChannelUiStates.Loaded
    }
    fun loadUserInfo() = viewModelScope.launch {
        userDao.getAllUsers().forEach {
            userInfoList.add(it)
        }
        hideLoader()
    }

    fun loadProfileImages() = viewModelScope.launch {
        userInfoList
            .filter { user ->
                user.userId != userId
            }
            .forEach { user ->
                userDao.getUserProfilePic(user.userId)?.let {
                    userProfileImages.add(
                        EntityImage(
                            entityId = user.userId,
                            image = it.toImageBitmap()
                        )
                    )
                }
            }
    }

    fun updateButtonState() {
        enableButton = channelMembersList.size > 1
    }

    fun updateChannelMembersList(memberId: Int, selected: Boolean) {
        if (selected && !channelMembersList.contains(memberId)) channelMembersList.add(memberId)
        else if (!selected && channelMembersList.contains(memberId)) channelMembersList.remove(
            memberId
        )
        updateButtonState()
    }
    fun initChannelName() {
        if(channelMembersList.size > 1)
            for (i in 0..1) {
                channelMembersList[i].let { memberId ->
                    userInfoList.forEach { user ->
                        if (user.userId == memberId)
                            channelName =
                                if(user.displayName.trim().isNotEmpty()) TextFieldValue(channelName.text.plus(user.displayName)) else TextFieldValue(channelName.text.plus(user.username))
                    }
                }
                channelName = TextFieldValue(channelName.text.plus(","))
            }
        else
            error = "At least select one member."
    }

    fun insertChannel() = viewModelScope.launch {
        if(isError) return@launch
        if (channelName.text.trim().isNotEmpty())
            newChannelId = channelDao.insertAndGetChannelId(
                ChannelEntity(
                channelName = channelName.text.trim(),
                userCreatedId = userId,
                channelImage = null
                )
            )
        if (newChannelId == null || newChannelId == -1) error = "Couldn't fetch or create channel"
    }
    fun insertMembers() = viewModelScope.launch {
        if(newChannelId == null || newChannelId == -1) error = "Couldn't fetch or created channel Id"
        else channelMembersList.forEach { memberId ->
            channelDao.insertChannelMember(channelId = newChannelId!!, memberId)
        }
    }
    fun createChannel() = viewModelScope.launch {
        showLoader()
        initChannelName()
        insertChannel().join()
        insertMembers().join()
        hideLoader()
        if (newChannelId != null) uiStates = CreateChannelUiStates.ChannelCreated(channelId = newChannelId!!)
        else error = "Couldn't generate or fetch Channel ID."
    }
}