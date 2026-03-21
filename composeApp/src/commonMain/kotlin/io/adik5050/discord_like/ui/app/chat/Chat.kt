package io.adik5050.discord_like.ui.app.chat

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import io.adik5050.discord_like.platform_specific.toClipEntry
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.UserSession
import io.adik5050.discord_like.ui.app.chat.composables.ChatContent
import io.adik5050.discord_like.ui.app.chat.composables.ChatTextField
import io.adik5050.discord_like.ui.app.chat.composables.ChatTopBar
import io.adik5050.discord_like.ui.app.chat.composables.DeleteMessageDialog
import io.adik5050.discord_like.ui.app.chat.composables.TextFieldMessageOption
import io.adik5050.discord_like.ui.app.chat.viewmodels.ChatViewModel
import kotlinx.coroutines.launch

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

    // adding copy to clipboard functionality
    val clipboard = LocalClipboard.current

    LaunchedEffect(chatViewModel.currentMessageOption) {
        chatViewModel.copyMessage()?.let {
            clipboard.setClipEntry(it.toClipEntry())
        }
        chatViewModel.clearCurrentOption()
    }

    LaunchedEffect(Unit) {
        chatViewModel.loadProfileImages()
    }
    LaunchedEffect(chatViewModel.error) {
        println(chatViewModel.error)
    }
    Surface (
        modifier = modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
            .windowInsetsPadding(WindowInsets.navigationBars),
        color = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {
        val scrollState = rememberScrollState()
        val coroutineScope = rememberCoroutineScope()
        val keyboardHeight = WindowInsets.ime.getBottom(LocalDensity.current)

        LaunchedEffect(key1 = keyboardHeight) {
            coroutineScope.launch {
                scrollState.scrollBy(keyboardHeight.toFloat())
            }
        }

        Column (
            modifier = Modifier
                .verticalScroll(scrollState),
        ) {
            ChatTopBar(
                channelName = chatViewModel.channelInfo?.channelName,
                onClickBack = onNavigateToHome
            )
            ChatContent(
                modifier = Modifier
                    .weight(1f),
                chatViewModel.userId,
                channelMembers,
                messageHistory,
                chatViewModel.memberProfileImages,
                onClickOption = chatViewModel::onClickOption
            )
            Box(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .background(color = MaterialTheme.colorScheme.surfaceContainerLowest,shape = MaterialTheme.shapes.medium)
            ) {
                Column {
                    if(chatViewModel.showTextFieldMessageOption) {
                        TextFieldMessageOption(
                            displayName = chatViewModel.currentUserInfo?.displayName ?: "",
                            messageOption = chatViewModel.currentMessageOption,
                            onClickCancel = chatViewModel::clearCurrentOption
                        )
                    }
                    ChatTextField(
                        message = chatViewModel.message,
                        messagePlaceHolder = chatViewModel.channelInfo?.channelName,
                        onMessageChanged = chatViewModel::updateMessage,
                        onCLickSend = {
                            chatViewModel.addMessage()
                        }
                    )
                }
            }
        }
        AnimatedVisibility(chatViewModel.deleteMessageDialogState) {
            DeleteMessageDialog(
                onCancel = { chatViewModel.updateDeleteMessageDialogState(false) },
                onConfirm = chatViewModel::deleteMessage,
                displayName = chatViewModel.currentUserInfo?.displayName,
                message = chatViewModel.currentMessageInfo?.message?.decodeToString()
            )
        }
    }
}