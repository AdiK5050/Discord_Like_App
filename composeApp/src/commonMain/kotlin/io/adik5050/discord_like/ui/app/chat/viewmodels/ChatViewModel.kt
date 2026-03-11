package io.adik5050.discord_like.ui.app.chat.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wannaverse.imageselector.toImageBitmap
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.ChannelDao
import io.adik5050.discord_like.storage.ChannelEntity
import io.adik5050.discord_like.storage.MessageDao
import io.adik5050.discord_like.storage.MessageEntity
import io.adik5050.discord_like.storage.MessageType
import io.adik5050.discord_like.storage.UserDao
import io.adik5050.discord_like.storage.UserSession
import io.adik5050.discord_like.ui.app.chat.composables.MessageOption
import io.adik5050.discord_like.ui.app.chat.composables.allMessageOptions
import io.adik5050.discord_like.ui.app.create_channel.viewmodels.EntityImage
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ChatViewModel(
    appDatabase: AppDatabase,
    userSession: UserSession,
    val channelId: Int,
) : ViewModel() {

    val userId = userSession.getUserId()
    val userDao: UserDao = appDatabase.getUserDao()
    val messageDao: MessageDao = appDatabase.getMessageDao()
    val channelDao: ChannelDao = appDatabase.getChannelDao()

    var channelInfo: ChannelEntity? = null

    var message by mutableStateOf(TextFieldValue(""))
        private set

    var error by mutableStateOf("")
        private set

    var showTextFieldMessageOption by mutableStateOf(false)
        private set
    var currentMessageOption: MessageOption? by mutableStateOf(null)
        private set
    var currentMessageInfo: MessageEntity? by mutableStateOf(null)
        private set
    var currentUserInfo: UserInfo? by mutableStateOf(null)
        private set
    val memberProfileImages: SnapshotStateList<EntityImage> = mutableStateListOf()

    val channelMembers = userDao.getUserWithChannelId(channelId)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
    val messageHistory = messageDao.getAllMessagesByChannelID(channelId)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    init {
        viewModelScope.launch {
            loadChannelInfo().join()
            if(channelInfo == null) error = "Channel Not Found"
        }
    }

    fun loadChannelInfo() = viewModelScope.launch {
        channelDao.getChannelById(channelId)?.let {
            channelInfo = it
        }
    }

    fun loadProfileImages() = viewModelScope.launch {
        channelMembers.value
            .filter { user ->
                user.userId != userId
            }
            .forEach { user ->
                userDao.getUserProfilePic(user.userId)?.let {
                    memberProfileImages.add(
                        EntityImage(
                            entityId = user.userId,
                            image = it.toImageBitmap()
                        )
                    )
                }
            }
    }

    fun onClickOption(messageOptionId: Int, messageId: Int) {
        allMessageOptions.firstOrNull { messageOptionId == it.optionId } ?.let {
            currentMessageOption = it
        } ?: {
            error = "Message Option Missing!"
        }

        updateShowTextFieldMessageOption()

        when(currentMessageOption) {
            MessageOption.EDIT -> editMessage(messageId)
            MessageOption.REPLY -> replyToMessage(messageId)
            else -> { error = "Message Option Missing!" }
        }
    }

    fun replyToMessage(messageId: Int) {
        messageHistory.value.firstOrNull { it.messageId == messageId } ?.let { message ->
            channelMembers.value.firstOrNull {  it.userId == message.senderId }?.let {
                currentUserInfo = it
                println(currentUserInfo)
            } ?: {
                error = "replyToMessage: sender not found"
            }
        }  ?: {
                error = "replyToMessage: message not found"
            }
        messageHistory.value.firstOrNull { it.messageId == messageId }?.let {
            currentMessageInfo = it
        } ?: {
            error = "Message Info Missing"
        }
    }

    fun editMessage(messageId: Int) {
        messageHistory.value.firstOrNull { it.messageId == messageId }?.let {
            currentMessageInfo = it
            val messageToEdit = it.message.decodeToString()
            message = TextFieldValue(text = messageToEdit, selection = TextRange(messageToEdit.length))
        } ?: {
            error = "Message Info Missing"
        }
    }

    fun forwardMessage() {

    }

    fun copyMessage() {

    }
    fun updateShowTextFieldMessageOption() {
        showTextFieldMessageOption = when (currentMessageOption) {
            MessageOption.REPLY, MessageOption.EDIT -> true
            null -> false
            else -> false
        }
    }

    fun clearCurrentOption() {
        currentMessageOption = null
        currentMessageInfo = null
        currentUserInfo = null
        updateShowTextFieldMessageOption()
    }
    fun clearTextField() {
        message = TextFieldValue("")
    }
    fun updateMessage(newMessage: TextFieldValue) {
        message = newMessage
    }
    fun addMessage() = viewModelScope.launch{
        if(message.text.trim().isEmpty()) return@launch
        else if(currentMessageOption == MessageOption.EDIT) {
            currentMessageInfo?.messageId?.let {
                messageDao.updateMessage(it, message.text.encodeToByteArray())
            } ?: {
                error = "Invalid or Missing Message Id!"
            }
        }
        else if(currentMessageOption == MessageOption.REPLY) {
            if(currentUserInfo == null)  {
                error = "Missing user info replying to."
            }
            messageDao.insertMessage(
                message = message.text.encodeToByteArray(),
                senderId = userId,
                channelId = channelId,
                repliedTo = currentMessageInfo?.messageId,
                messageType = MessageType.TEXT,
            )
        }
        else {
            messageDao.insertMessage(
                message = message.text.encodeToByteArray(),
                senderId = userId,
                channelId = channelId,
                repliedTo = null,
                messageType = MessageType.TEXT,
            )
        }
        clearTextField()
        clearCurrentOption()
    }
}

data class UserInfo (
    val userId: Int,
    val username: String,
    val displayName: String,
    val onlineStatus: String,
)