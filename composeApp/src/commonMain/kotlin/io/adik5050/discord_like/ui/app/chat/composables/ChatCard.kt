package io.adik5050.discord_like.ui.app.chat.composables

import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.shared.composables.ImageWithStatus
import io.adik5050.discord_like.shared.composables.OnlineStatus

@Composable
fun ChatCard (
    modifier: Modifier = Modifier,
    image: ImageBitmap?,
    status: OnlineStatus,
    name: String?,
    time: String,
    message: String,
    ownMessage: Boolean,
    updateIsSelectedMessageOwn: () -> Unit,
    onLongPressed: () -> Unit,
    onClickOption: (Int) -> Unit
) {
    val interactionSource by remember { mutableStateOf(MutableInteractionSource() ) }
    val isHovered by interactionSource.collectIsHoveredAsState()
    Box(
        modifier = modifier
            .fillMaxWidth()
            .combinedClickable(
                enabled = true,
                onLongClick = { onLongPressed() },
                onClick = {},
                interactionSource = interactionSource
            )
            .hoverable(
                interactionSource = interactionSource
            )
    ) {
        if(isHovered) {
            updateIsSelectedMessageOwn()
            MessageOptionsBar(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(end = 8.dp)
                    .offset(y = (-24).dp)
                    .hoverable(
                        interactionSource = interactionSource
                    ),
                optionList = if(ownMessage) ownMessageOptions else otherMessageOptions,
                onClickOption = onClickOption
            )
        }
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ImageWithStatus(
                modifier = Modifier
                    .padding(4.dp)
                    .size(56.dp),
                image = image,
                status = status,
            )
            Column (
                verticalArrangement = Arrangement.Center
            ){
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = name?:"User",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = time,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
@Stable
data class MessageCardData(
    var name: String,
    var message: String,
    var time: String,
    var image: ByteArray?,
    var status: OnlineStatus
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as MessageCardData

        if (!image.contentEquals(other.image)) return false

        return true
    }

    override fun hashCode(): Int {
        return image?.contentHashCode() ?: 0
    }
}