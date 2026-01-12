package io.adik5050.discord_like.ui.app.chat.viewmodels

import androidx.lifecycle.ViewModel
import io.adik5050.discord_like.shared.composables.OnlineStatus
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.ui.app.chat.composables.MessageCardData
import io.adik5050.discord_like.ui.app.chat.composables.messageCardDataListData

class ChatViewModel (
    appDatabase: AppDatabase
) : ViewModel() {
    private val _messageCardDataList = messageCardDataListData.toMutableList()
    val messageCardDataList: List<MessageCardData> = _messageCardDataList

    fun addMessage(message: String) {
        _messageCardDataList.add(MessageCardData(
            image = null,
            status = OnlineStatus.DO_NOT_DISTURB,
            name = "Rebecca",
            time = "7:43",
            message = message
        ))
    }
}