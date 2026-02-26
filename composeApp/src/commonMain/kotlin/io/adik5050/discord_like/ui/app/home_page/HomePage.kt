package io.adik5050.discord_like.ui.app.home_page

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.UserSession
import io.adik5050.discord_like.ui.app.chat_list.ChatList
import io.adik5050.discord_like.ui.app.home_page.viewmodels.HomeViewModel
import io.adik5050.discord_like.ui.app.server_list.ServerList


@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    appDatabase: AppDatabase,
    userSession: UserSession,
    homeViewModel: HomeViewModel = viewModel { HomeViewModel(appDatabase, userSession) },
    onClickMessageIcon: () -> Unit,
    onClickChatPage: () -> Unit,
    onNavigateToCreateChannel: () -> Unit
) {
    Row (
        modifier = modifier
            .fillMaxSize()
    ) {
        ServerList(
            modifier = Modifier,
            onClickMessageIcon = onClickMessageIcon
        )
        ChatList(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            onClickToChatPage = onClickChatPage,
            onClickSearchBar = onNavigateToCreateChannel
        )
    }
}