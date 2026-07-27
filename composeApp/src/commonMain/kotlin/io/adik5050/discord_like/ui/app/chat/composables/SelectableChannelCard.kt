package io.adik5050.discord_like.ui.app.chat.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.wannaverse.imageselector.toImageBitmap
import io.adik5050.discord_like.shared.composables.ImageWithStatus
import io.adik5050.discord_like.storage.ChannelEntity
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.check_box_blank
import myapplication.composeapp.generated.resources.check_box_filled
import myapplication.composeapp.generated.resources.not_selected
import myapplication.composeapp.generated.resources.selected
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun SelectableChannelCard(
    modifier: Modifier = Modifier,
    channelEntity: ChannelEntity,
    onClick: (Int, Boolean) -> Unit
) {
    var selected by remember { mutableStateOf(false) }
    Card (
        modifier = modifier.clickable(
            onClick = {
                selected = !selected
                onClick( channelEntity.channelId, selected )
            }
            )
    ) {
        Row (
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row (
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageWithStatus(
                    modifier = Modifier.size(56.dp),
                    image = channelEntity.channelImage?.toImageBitmap(),
                )
                Text(
                    text = channelEntity.channelName,
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.Start,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Icon(
                painter = painterResource( if(selected) Res.drawable.check_box_filled else Res.drawable.check_box_blank),
                contentDescription = stringResource(if(selected) Res.string.selected else Res.string.not_selected)
            )
        }
    }
}