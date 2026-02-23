package io.adik5050.discord_like.ui.app.create_channel.viewmodels

import androidx.lifecycle.ViewModel
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.UserSession
import io.adik5050.discord_like.ui.app.chat.viewmodels.RawUserInfo

class CreateChannelViewModel(
    appDatabase: AppDatabase,
    userSession: UserSession
) : ViewModel() {

    val userId = userSession.getUserId()
    val userDao = appDatabase.getUserDao()
    val channelDao = appDatabase.getChannelDao()

    private var rawUserInfo: List<RawUserInfo> = emptyList()


}