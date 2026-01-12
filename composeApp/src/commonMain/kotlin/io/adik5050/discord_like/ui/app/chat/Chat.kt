package io.adik5050.discord_like.ui.app.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.ui.app.chat.composables.ChatTopBar
import io.adik5050.discord_like.ui.app.chat.composables.MessageContent
import io.adik5050.discord_like.ui.app.chat.composables.MessageTextField
import io.adik5050.discord_like.ui.app.chat.viewmodels.ChatViewModel
import io.adik5050.discord_like.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Suppress("ParamsComparedByRef")
@Composable
fun Chat(
    modifier: Modifier = Modifier,
    appDatabase: AppDatabase,
    chatViewModel: ChatViewModel = viewModel { ChatViewModel(appDatabase) }
) {
    Surface (
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {
        Column (
            modifier = Modifier.padding(8.dp)
        ) {
            ChatTopBar()
            MessageContent(
                modifier = Modifier
                    .weight(1f),
                chatViewModel.messageCardDataList
            )
            MessageTextField()
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