package io.adik5050.discord_like.ui.app.chat.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.MessageDao
import io.adik5050.discord_like.storage.MessageType
import io.adik5050.discord_like.storage.UserDao
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ChatViewModel(
    appDatabase: AppDatabase,
    val channelId: Int,
) : ViewModel() {
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
        messageDao.insertMessage(
                message = message.encodeToByteArray(),
                senderId = 1,
                channelId = 1,
                repliedTo = null,
                messageType = MessageType.TEXT,
            )
    }
}

data class UserInfo(
    val userId: Int,
    val username: String,
    val profileImage: ByteArray?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as UserInfo

        if (username != other.username) return false
        if (!profileImage.contentEquals(other.profileImage)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = username.hashCode()
        result = 31 * result + profileImage.contentHashCode()
        return result
    }
}