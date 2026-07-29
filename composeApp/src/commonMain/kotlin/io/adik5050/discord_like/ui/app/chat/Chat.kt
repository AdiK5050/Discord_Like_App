package io.adik5050.discord_like.ui.app.chat

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.isAltPressed
import androidx.compose.ui.input.key.isCtrlPressed
import androidx.compose.ui.input.key.isMetaPressed
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.input.key.utf16CodePoint
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_EXPANDED_LOWER_BOUND
import io.adik5050.discord_like.platform_specific.toClipEntry
import io.adik5050.discord_like.shared.composables.EmojiSelector
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.UserSession
import io.adik5050.discord_like.ui.app.chat.composables.ChatContent
import io.adik5050.discord_like.ui.app.chat.composables.ChatTextField
import io.adik5050.discord_like.ui.app.chat.composables.ChatTopBar
import io.adik5050.discord_like.ui.app.chat.composables.DeleteMessageDialog
import io.adik5050.discord_like.ui.app.chat.composables.ForwardMessageBottomSheet
import io.adik5050.discord_like.ui.app.chat.composables.MessageOption
import io.adik5050.discord_like.ui.app.chat.composables.TextFieldMessageOption
import io.adik5050.discord_like.ui.app.chat.viewmodels.ChatViewModel

val TEXT_FIELD_HEIGHT = 72.dp
@Suppress("ParamsComparedByRef")
@Composable
fun ChatPage(
    modifier: Modifier = Modifier,
    appDatabase: AppDatabase,
    userSession: UserSession,
    windowSizeClass: WindowSizeClass,
    channelId: Int,
    chatViewModel: ChatViewModel = viewModel { ChatViewModel(appDatabase, userSession,channelId) },
    onNavigateToHome: () -> Unit
) {
    val isLandscape = windowSizeClass.isWidthAtLeastBreakpoint(WIDTH_DP_EXPANDED_LOWER_BOUND)

    val channelMembers by chatViewModel.channelMembers.collectAsStateWithLifecycle()
    val messageHistory by chatViewModel.messageHistory.collectAsStateWithLifecycle()

    //Emoji Selector Behavior
    val textFieldFocusRequester = remember { FocusRequester() }
    val rootFocusRequester = remember { FocusRequester() }
    val keyboardManager = LocalSoftwareKeyboardController.current
    var showEmojiSelector by remember { mutableStateOf(false) }

    // Give the screen focus so it receives physical-keyboard key events.
    LaunchedEffect(Unit) {
        rootFocusRequester.requestFocus()
    }

    // Adding copy to clipboard functionality
    val clipboard = LocalClipboard.current

    LaunchedEffect(chatViewModel.currentMessageOption) {
        chatViewModel.currentMessageOption?.let { option ->
            if (option.optionId == MessageOption.COPY.optionId) {
                chatViewModel.copyMessage()?.let {
                    clipboard.setClipEntry(it.toClipEntry())
                }
                chatViewModel.clearCurrentOption()
            }
        }
    }

    LaunchedEffect(channelMembers) {
        chatViewModel.loadProfileImages(channelMembers)
    }
    LaunchedEffect(chatViewModel.error) {
        chatViewModel.error?.let {
            println(chatViewModel.error)
        }
    }
    Surface(
        modifier = modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
            .windowInsetsPadding(WindowInsets.navigationBars.only(WindowInsetsSides.Bottom + WindowInsetsSides.End))
            .focusRequester(rootFocusRequester)
            .onPreviewKeyEvent { event ->
                // Must sit ABOVE focusable so it tunnels through even when the
                // root itself (not the text field) holds focus.
                if (event.type == KeyEventType.KeyDown &&
                    !event.isCtrlPressed &&
                    !event.isMetaPressed &&
                    !event.isAltPressed
                ) {
                    val codePoint = event.utf16CodePoint
                    val isLetter = codePoint != 0 && Char(codePoint).isLetter()
                    val isShift = event.key == Key.ShiftLeft || event.key == Key.ShiftRight
                    if ((isLetter || isShift) && !showEmojiSelector) {
                        textFieldFocusRequester.requestFocus()
                    }
                }
                // Never consume the event; let the now-focused field handle it.
                false
            }
            .focusable()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                // Click on empty space (children consume their own clicks):
                // close the emoji selector and drop the text field's focus.
                showEmojiSelector = false
                rootFocusRequester.requestFocus()
            },
        color = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
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
                        focusRequester = textFieldFocusRequester,
                        message = chatViewModel.message,
                        messagePlaceHolder = chatViewModel.channelInfo?.channelName,
                        onMessageChanged = chatViewModel::updateMessage,
                        showEmojiSelector = showEmojiSelector,
                        textFieldHeight = TEXT_FIELD_HEIGHT,
                        onCLickSend = {
                            chatViewModel.addMessage()
                        },
                        onClickSmiley = {
                            showEmojiSelector = !showEmojiSelector
                            if(showEmojiSelector) keyboardManager?.hide()
                            else {
                                textFieldFocusRequester.requestFocus()
                                keyboardManager?.show()
                            }
                        }
                    )
                }
            }
        }
        AnimatedVisibility(showEmojiSelector) {
                EmojiSelector(
                    modifier = Modifier
                        .fillMaxWidth(if (isLandscape) 0.5f else 1f)
                        .padding(8.dp)
                        .padding(bottom = TEXT_FIELD_HEIGHT),
                    onEmojiSelected = {},
                )
        }
        AnimatedVisibility(chatViewModel.deleteMessageDialogState) {
            DeleteMessageDialog(
                onCancel = { chatViewModel.updateDeleteMessageDialogState(false) },
                onConfirm = chatViewModel::deleteMessage,
                displayName = chatViewModel.currentUserInfo?.displayName,
                message = chatViewModel.currentMessageInfo?.message?.decodeToString()
            )
        }
        AnimatedVisibility(chatViewModel.forwardMessageSheetState) {
            ForwardMessageBottomSheet(
                onCancel = { chatViewModel.updateForwardMessageSheetState(false) },
                channelList = chatViewModel.channelList,
                onForward = chatViewModel::forwardMessage
            )
        }
    }
}