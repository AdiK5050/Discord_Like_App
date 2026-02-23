package io.adik5050.discord_like.ui.app.chat_list.viewmodels

import androidx.lifecycle.ViewModel
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.UserSession

class ChatListViewModel(
    appDatabase: AppDatabase,
    userSession: UserSession,
): ViewModel() {

    val userId = userSession.getUserId()
    val channelDao = appDatabase.getChannelDao()
}