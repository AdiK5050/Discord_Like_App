package io.adik5050.discord_like.ui.app.chat_list.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.shared.composables.Image_With_Status
import io.adik5050.discord_like.shared.composables.OnlineStatus

@Composable
fun ChatListCard(
    modifier: Modifier = Modifier,
    image: ByteArray? = null,
    status: OnlineStatus = OnlineStatus.ONLINE,
    name: String,
    lastMessage: String,
    onClick: () -> Unit
) {
    Card (
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image_With_Status(
                image = image,
                status = status,
                clickable = false,
                onClick = {}
            )
            Column (
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = lastMessage,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}