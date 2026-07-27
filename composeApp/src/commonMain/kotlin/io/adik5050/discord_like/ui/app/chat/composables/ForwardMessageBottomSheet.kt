package io.adik5050.discord_like.ui.app.chat.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.storage.ChannelEntity
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.arrow_back
import myapplication.composeapp.generated.resources.cancel_button
import myapplication.composeapp.generated.resources.forward
import myapplication.composeapp.generated.resources.forward_button
import myapplication.composeapp.generated.resources.forward_message_channel_list_empty
import myapplication.composeapp.generated.resources.forward_message_header
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("ParamsComparedByRef")
@Composable
fun ForwardMessageBottomSheet(
    channelList: List<ChannelEntity>,
    onCancel: () -> Unit,
    onForward: (Map<Int,Boolean>) -> Unit
) {
    val selectedChannels: MutableMap<Int, Boolean> = remember { mutableMapOf() }
    var enableForwardButton by remember { mutableStateOf(false) }
    ModalBottomSheet(
        onDismissRequest = onCancel
    ) {
        if(channelList.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxHeight(0.5f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = stringResource(Res.string.forward_message_channel_list_empty),
                    textAlign = TextAlign.Center
                )
            }
        }
        else
            Card {
                LazyColumn {
                    item {
                        ForwardMessageHeader(
                            enableForwardButton = enableForwardButton,
                            onCancel = onCancel,
                            onForward = { onForward(selectedChannels) }
                        )
                    }
                    items(channelList, key = { it.channelId }) {
                        SelectableChannelCard(
                            channelEntity = it,
                            onClick = { channelId, selectedState ->
                                selectedChannels[channelId] = selectedState
                                enableForwardButton = selectedChannels.values.contains(true)
                            }
                        )
                    }
                }
            }
    }
}

@Composable
fun ForwardMessageHeader(
    modifier: Modifier = Modifier,
    enableForwardButton: Boolean,
    onCancel: () -> Unit,
    onForward: () -> Unit
) {
    Row (
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = onCancel
        ) {
            Icon(
                painter = painterResource(Res.drawable.arrow_back),
                contentDescription = stringResource(Res.string.cancel_button)
            )
        }
        Text(
            text = stringResource(Res.string.forward_message_header),
            style = MaterialTheme.typography.titleLarge
        )
        IconButton(
            enabled = enableForwardButton,
            onClick = onForward
        ) {
            Icon(
                painter = painterResource(Res.drawable.forward),
                contentDescription = stringResource(Res.string.forward_button)
            )
        }
    }
}