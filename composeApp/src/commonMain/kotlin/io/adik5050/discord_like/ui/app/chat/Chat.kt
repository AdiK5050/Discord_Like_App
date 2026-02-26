package io.adik5050.discord_like.ui.app.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.UserSession
import io.adik5050.discord_like.ui.app.chat.composables.ChatTopBar
import io.adik5050.discord_like.ui.app.chat.composables.MessageContent
import io.adik5050.discord_like.ui.app.chat.composables.MessageTextField
import io.adik5050.discord_like.ui.app.chat.viewmodels.ChatViewModel
import io.adik5050.discord_like.ui.theme.AppTheme

@Suppress("ParamsComparedByRef")
@Composable
fun ChatPage(
    modifier: Modifier = Modifier,
    appDatabase: AppDatabase,
    userSession: UserSession,
    channelId: Int,
    chatViewModel: ChatViewModel = viewModel { ChatViewModel(appDatabase, userSession,channelId) },
    onNavigateToHome: () -> Unit
) {
    val channelMembers by chatViewModel.channelMembers.collectAsStateWithLifecycle()
    val messageHistory by chatViewModel.messageHistory.collectAsStateWithLifecycle() 
    Surface (
        modifier = modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
            .windowInsetsPadding(WindowInsets.navigationBars),
        color = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {
        Column (
            modifier = Modifier.padding(8.dp)
        ) {
            ChatTopBar(
                onClickBack = {
                    onNavigateToHome()
                }
            )
            MessageContent(
                modifier = Modifier
                    .weight(1f),
                channelMembers,
                messageHistory
            )
            MessageTextField(
                onCLickSend = { message ->
                    chatViewModel.addMessage(message)
                }
            )
        }
    }
}

@Preview
@Composable
fun PreviewChat() {
    AppTheme (
        darkTheme = true
    ){
        Surface {

        }
    }
}