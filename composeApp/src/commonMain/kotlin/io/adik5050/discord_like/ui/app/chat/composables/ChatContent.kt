package io.adik5050.discord_like.ui.app.chat.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.shared.composables.stringToOnlineStatus
import io.adik5050.discord_like.storage.MessageEntity
import io.adik5050.discord_like.ui.app.chat.viewmodels.UserInfo

@Composable
fun ChatContent (
    modifier: Modifier = Modifier,
    channelMembers: List<UserInfo>,
    messageHistory: List<MessageEntity>,
    onClickOption: (optionId: Int, messageId: Int) -> Unit,
) {
    var showBottomSheet by remember { mutableStateOf(false) }
    var currentMessageId by remember { mutableStateOf(0)}
    Surface (
        modifier = modifier
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(messageHistory, {it.messageId}) { message ->
                val user = channelMembers.firstOrNull { it.userId == message.senderId }
                ChatCard(
                    image = null,
                    status = stringToOnlineStatus(user?.onlineStatus),
                    name = user?.displayName,
                    time = message.sentAt,
                    message = message.message.decodeToString(),
                    onLongPressed = {
                        showBottomSheet = true
                        currentMessageId = message.messageId
                    },
                    onClickOption = {
                        onClickOption(it, message.messageId)
                    }
                )
            }
        }
        Box {
            AnimatedVisibility(showBottomSheet) {
                MessageOptionsBottomSheet(
                    onDismissRequest = { showBottomSheet = false },
                    onClickOption = {
                        onClickOption(it, currentMessageId)
                    }
                )
            }
        }
    }
}