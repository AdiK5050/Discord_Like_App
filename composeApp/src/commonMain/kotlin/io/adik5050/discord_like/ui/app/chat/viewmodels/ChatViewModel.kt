package io.adik5050.discord_like.ui.app.chat.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.ChannelDao
import io.adik5050.discord_like.storage.ChannelEntity
import io.adik5050.discord_like.storage.MessageDao
import io.adik5050.discord_like.storage.MessageType
import io.adik5050.discord_like.storage.UserDao
import io.adik5050.discord_like.storage.UserSession
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

    fun loadChannelInfo() = viewModelScope.launch {
        channelDao.getChannelById(channelId)?.let {
            channelInfo = it
        }
    }
    init {
        viewModelScope.launch {
            loadChannelInfo().join()
            if(channelInfo == null) error = "Channel Not Found"
        }
    }

    fun updateMessage(newMessage: TextFieldValue) {
        message = newMessage
    }
    fun addMessage(repliedTo: Int?) = viewModelScope.launch{
        if(message.text.trim().isNotEmpty()) {
            messageDao.insertMessage(
                message = message.text.encodeToByteArray(),
                senderId = userId,
                channelId = channelId,
                repliedTo = repliedTo,
                messageType = MessageType.TEXT,
            )
        }
        message = TextFieldValue("")
    }
}

data class UserInfo(
    val userId: Int,
    val username: String,
    val displayName: String,
    val onlineStatus: String,
)