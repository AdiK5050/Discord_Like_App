package io.adik5050.discord_like.ui.app.chat.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.arrow_back
import myapplication.composeapp.generated.resources.call
import myapplication.composeapp.generated.resources.pin
import myapplication.composeapp.generated.resources.video
import org.jetbrains.compose.resources.painterResource

@Composable
fun ChatTopBar (
    modifier: Modifier = Modifier,
    channelName: String? ,
    onClickCall: () -> Unit = {},
    onCLickVideo: () -> Unit = {},
    onClickPin: () -> Unit = {},
    onClickBack: () -> Unit,
) {
    Row (
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,) {
            IconButton(
                modifier = Modifier
                    .clip(CircleShape),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer,
                    contentColor = MaterialTheme.colorScheme.onSurface
                ),
                onClick = onClickBack,
                content = {
                    Icon(
                        painter = painterResource(Res.drawable.arrow_back),
                        contentDescription = "Back",
                    )
                }
            )
            Text(
                text = channelName ?: "",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically,) {
            IconButton(
                modifier = Modifier
                    .clip(CircleShape),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer,
                    contentColor = MaterialTheme.colorScheme.onSurface
                ),
                onClick = onClickCall,
                content = {
                    Icon(
                        painter = painterResource(Res.drawable.call),
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
                onClick = onCLickVideo,
                content = {
                    Icon(
                        painter = painterResource(Res.drawable.video),
                        contentDescription = "Video",
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
                onClick = onClickPin,
                content = {
                    Icon(
                        painter = painterResource(Res.drawable.pin),
                        contentDescription = "Pin",
                    )
                }
            )
        }
    }
}