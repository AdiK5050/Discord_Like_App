package io.adik5050.discord_like.ui.app.chat.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.shared.composables.OnlineStatus
import io.adik5050.discord_like.storage.MessageEntity
import io.adik5050.discord_like.ui.app.chat.viewmodels.UserInfo

@Composable
fun MessageContent (
    modifier: Modifier = Modifier,
    channelMembers: List<UserInfo>,
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
                    image = user?.profileImage,
                    status = OnlineStatus.INVISIBLE,
                    name = user?.username,
                    time = message.sentAt,
                    message = message.message.decodeToString(),
                )
            }
        }
    }
}
val messageCardDataListData = listOf<MessageCardData>(
    MessageCardData(
        image = null,
        status = OnlineStatus.DO_NOT_DISTURB,
        name = "Rebecca",
        time = "7:43",
        message = "What Gives, I'll have it set up soon!"
    ),
    MessageCardData(
        image = null,
        status = OnlineStatus.DO_NOT_DISTURB,
        name = "Rebecca",
        time = "7:43",
        message = "What Gives, I'll have it set up soon!"
    ),
    MessageCardData(
        image = null,
        status = OnlineStatus.DO_NOT_DISTURB,
        name = "Rebecca",
        time = "7:43",
        message = "What Gives, I'll have it set up soon!"
    ),
    MessageCardData(
        image = null,
        status = OnlineStatus.DO_NOT_DISTURB,
        name = "Rebecca",
        time = "7:43",
        message = "What Gives, I'll have it set up soon!"
    ),
    MessageCardData(
        image = null,
        status = OnlineStatus.DO_NOT_DISTURB,
        name = "Rebecca",
        time = "7:43",
        message = "What Gives, I'll have it set up soon!"
    ),
    MessageCardData(
        image = null,
        status = OnlineStatus.DO_NOT_DISTURB,
        name = "Rebecca",
        time = "7:43",
        message = "What Gives, I'll have it set up soon!"
    ),
    MessageCardData(
        image = null,
        status = OnlineStatus.INVISIBLE,
        name = "Roberto",
        time = "4:38",
        message = "Guess what? The slacker thinks he is in control."
    ),
    MessageCardData(
        image = null,
        status = OnlineStatus.INVISIBLE,
        name = "Roberto",
        time = "4:38",
        message = "Guess what? The slacker thinks he is in control."
    ),
    MessageCardData(
        image = null,
        status = OnlineStatus.INVISIBLE,
        name = "Roberto",
        time = "4:38",
        message = "Guess what? The slacker thinks he is in control."
    ),
    MessageCardData(
        image = null,
        status = OnlineStatus.INVISIBLE,
        name = "Roberto",
        time = "4:38",
        message = "Guess what? The slacker thinks he is in control."
    ),
    MessageCardData(
        image = null,
        status = OnlineStatus.INVISIBLE,
        name = "Roberto",
        time = "4:38",
        message = "Guess what? The slacker thinks he is in control."
    ),
    MessageCardData(
        image = null,
        status = OnlineStatus.INVISIBLE,
        name = "Roberto",
        time = "4:38",
        message = "Guess what? The slacker thinks he is in control."
    ),
    MessageCardData(
        image = null,
        status = OnlineStatus.ONLINE,
        name = "Richard",
        time = "6:25",
        message = "I don't have any sample data and it sucks!"
    ),
    MessageCardData(
        image = null,
        status = OnlineStatus.ONLINE,
        name = "Richard",
        time = "6:25",
        message = "I don't have any sample data and it sucks!"
    ),
    MessageCardData(
        image = null,
        status = OnlineStatus.ONLINE,
        name = "Richard",
        time = "6:25",
        message = "I don't have any sample data and it sucks!"
    ),
    MessageCardData(
        image = null,
        status = OnlineStatus.ONLINE,
        name = "Richard",
        time = "6:25",
        message = "I don't have any sample data and it sucks!"
    ),
    MessageCardData(
        image = null,
        status = OnlineStatus.ONLINE,
        name = "Richard",
        time = "6:25",
        message = "I don't have any sample data and it sucks!"
    ),
    MessageCardData(
        image = null,
        status = OnlineStatus.ONLINE,
        name = "Richard",
        time = "6:25",
        message = "I don't have any sample data and it sucks!"
    ),

)
