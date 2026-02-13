package io.adik5050.discord_like.ui.app.home_page.viewmodels

import androidx.lifecycle.ViewModel
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.UserSession

class HomeViewModel(
    val appDatabase: AppDatabase,
    userSession: UserSession
): ViewModel() {

    val channelDao = appDatabase.getChannelDao()
}