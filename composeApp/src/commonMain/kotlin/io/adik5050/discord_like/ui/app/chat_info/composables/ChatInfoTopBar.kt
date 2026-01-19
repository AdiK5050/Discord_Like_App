package io.adik5050.discord_like.ui.app.chat_info.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.shared.composables.ImageWithStatus
import io.adik5050.discord_like.shared.composables.OnlineStatus
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.notifications_hollow
import myapplication.composeapp.generated.resources.settings_hollow
import org.jetbrains.compose.resources.painterResource

@Composable
fun ChatInfoTopBar(
    modifier: Modifier = Modifier,
    name: String = "Mrs. Jennifer Lawrence",
    image: ByteArray? = null,
    status: OnlineStatus = OnlineStatus.ONLINE,
    onClickSettings: () -> Unit = {},
    onClickNotifications: () -> Unit = {},
    onClickProfile: () -> Unit = {}
) {
    Row (
        modifier = modifier
            .padding(top = 8.dp, bottom = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row {
            IconButton(
                modifier = Modifier
                    .clip(CircleShape),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer,
                    contentColor = MaterialTheme.colorScheme.onSurface
                ),
                onClick = onClickSettings,
                content = {
                    Icon(
                        painter = painterResource(Res.drawable.settings_hollow),
                        contentDescription = "Call",
                    )
                }
            )
            IconButton(
                modifier = Modifier
                    .clip(CircleShape),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer,
                    contentColor = MaterialTheme.colorScheme.onSurface
                ),
                onClick = onClickNotifications,
                content = {
                    Icon(
                        painter = painterResource(Res.drawable.notifications_hollow),
                        contentDescription = "Call",
                    )
                }
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Text(
                modifier = Modifier.weight(1f),
                text = name,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.End,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis

            )
            ImageWithStatus(
                image = image,
                status = status,
                clickable = true,
                onClick = onClickProfile
            )
        }
    }
}
