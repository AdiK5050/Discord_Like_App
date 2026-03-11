package io.adik5050.discord_like.ui.app.chat.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.shared.composables.stringToOnlineStatus
import io.adik5050.discord_like.storage.MessageEntity
import io.adik5050.discord_like.ui.app.chat.viewmodels.UserInfo
import io.adik5050.discord_like.ui.app.create_channel.viewmodels.EntityImage

@Composable
fun ChatContent (
    modifier: Modifier = Modifier,
    userId: Int,
    channelMembers: List<UserInfo>,
    messageHistory: List<MessageEntity>,
    memberProfileImages: SnapshotStateList<EntityImage>,
    onClickOption: (optionId: Int, messageId: Int) -> Unit,
) {
    var showBottomSheet by remember { mutableStateOf(false) }
    var currentMessageId by remember { mutableStateOf(0) }

    var isSelectedMessageOwn by remember { mutableStateOf(false) }
    Surface (
        modifier = modifier
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(messageHistory, {it.messageId}) { message ->
                val user = channelMembers.firstOrNull { it.userId == message.senderId }
                var image: ImageBitmap? by remember { mutableStateOf(null) }

                val repliedToMessageInfo = messageHistory.firstOrNull { it.messageId == message.repliedTo }
                val repliedToUserInfo = channelMembers.firstOrNull { it.userId == repliedToMessageInfo?.senderId }
                var repliedUserImage: ImageBitmap? by remember { mutableStateOf(null) }

                memberProfileImages.forEach { (entityId, img) ->
                    if(user?.userId == entityId) image = img
                    if(repliedToUserInfo?.userId == entityId) repliedUserImage = img
                }

                Box {
                    Column {
                        if (message.repliedTo != null) {
                            ReplyCard(
                                displayName = repliedToUserInfo?.displayName,
                                message = repliedToMessageInfo?.message?.decodeToString(),
                                image = repliedUserImage
                            )
                        }
                        ChatCard(
                            image = image,
                            status = stringToOnlineStatus(user?.onlineStatus),
                            name = user?.displayName,
                            time = message.sentAt,
                            message = message.message.decodeToString(),
                            onLongPressed = {
                                showBottomSheet = true
                                currentMessageId = message.messageId
                                isSelectedMessageOwn = message.senderId == userId
                            },
                            ownMessage = isSelectedMessageOwn,
                            updateIsSelectedMessageOwn = {
                                isSelectedMessageOwn = message.senderId == userId
                            },
                            onClickOption = {
                                onClickOption(it, message.messageId)
                            }
                        )
                    }
                }
            }
        }
        Box {
            AnimatedVisibility(showBottomSheet) {
                MessageOptionsBottomSheet(
                    onDismissRequest = { showBottomSheet = false },
                    ownMessage = isSelectedMessageOwn,
                    onClickOption = {
                        onClickOption(it, currentMessageId)
                        showBottomSheet = false
                    }
                )
            }
        }
    }
}