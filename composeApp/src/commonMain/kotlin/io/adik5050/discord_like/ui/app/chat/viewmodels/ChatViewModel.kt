package io.adik5050.discord_like.ui.app.chat.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.adik5050.discord_like.storage.AppDatabase
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
    fun addMessage(message: String) = viewModelScope.launch{
        if(message.trim().isNotEmpty()) {
            messageDao.insertMessage(
                message = message.encodeToByteArray(),
                senderId = userId,
                channelId = channelId,
                repliedTo = null,
                messageType = MessageType.TEXT,
            )
        }
    }
}

data class UserInfo(
    val userId: Int,
    val username: String,
    val displayName: String,
    val onlineStatus: String,
)