package io.adik5050.discord_like.ui.app.chat_list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.ui.app.chat_list.composables.ChatListCard
import io.adik5050.discord_like.ui.app.chat_list.composables.ChatListSearchBar
import io.adik5050.discord_like.ui.app.create_channel.viewmodels.EntityImage
import io.adik5050.discord_like.ui.app.home_page.viewmodels.ChannelInfo
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.group_add
import myapplication.composeapp.generated.resources.new_channel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ChatList(
    modifier: Modifier = Modifier,
    channelList: List<ChannelInfo>,
    entityImageList: SnapshotStateList<EntityImage>,
    onClickSearchBar: () -> Unit,
    onNavigateToChannel: (Int) -> Unit,
    onNavigateToCreateChannel: () -> Unit,
) {
    Surface (
        modifier = modifier,
        color = MaterialTheme.colorScheme.surfaceContainer,
        shape = MaterialTheme.shapes.medium
    ) {
        Box {
            var showText by mutableStateOf(false)
            val scrollState by mutableStateOf(rememberLazyListState(0))
            scrollState.scrollIndicatorState?.scrollOffset?.let { if(it > 1) showText = true }
            Column {
                ChatListSearchBar(
                    onClickSearchBar = onClickSearchBar
                )
                LazyColumn (
                    modifier = Modifier.padding(8.dp),
                    state = scrollState
                ) {
                    items(channelList) { channel ->
                        var image: ImageBitmap? by remember { mutableStateOf(null) }
                        entityImageList
                            .forEach { entity ->
                                if(entity.entityId == channel.channelId) {
                                    image = entity.image
                                }
                            }
                        ChatListCard(
                            image = image,
                            name = channel.channelName,
                            lastMessage = channel.message?.decodeToString(),
                            onClick = {
                                onNavigateToChannel(channel.channelId)
                            }
                        )
                    }
                }
            }
            FloatingActionButton(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomEnd),
                onClick = onNavigateToCreateChannel,
                shape = FloatingActionButtonDefaults.largeShape,
            ) {

                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.group_add),
                        contentDescription = stringResource(Res.string.new_channel)
                    )
                    AnimatedVisibility(showText) {
                        Text(
                            text = stringResource(Res.string.new_channel)
                        )
                    }
                }
            }
        }
    }
}
