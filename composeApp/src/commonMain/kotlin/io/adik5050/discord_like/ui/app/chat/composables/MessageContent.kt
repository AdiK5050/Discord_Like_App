package io.adik5050.discord_like.ui.app.chat.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.decodeToImageBitmap
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.shared.composables.convertToOnlineStatus
import io.adik5050.discord_like.storage.MessageEntity
import io.adik5050.discord_like.ui.app.chat.viewmodels.RawUserInfo

@Composable
fun MessageContent (
    modifier: Modifier = Modifier,
    channelMembers: List<RawUserInfo>,
    messageHistory: List<MessageEntity>
) {
    Surface (
        modifier = modifier
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(messageHistory) { message ->
                val user = channelMembers.firstOrNull { it.userId == message.senderId }
                MessageCard(
                    image = user?.profileImage?.decodeToImageBitmap(),
                    status = convertToOnlineStatus(user?.onlineStatus),
                    name = user?.displayName,
                    time = message.sentAt,
                    message = message.message.decodeToString(),
                )
            }
        }
    }
}