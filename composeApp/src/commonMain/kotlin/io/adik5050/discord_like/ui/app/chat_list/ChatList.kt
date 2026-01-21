package io.adik5050.discord_like.ui.app.chat_list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.ui.app.chat_list.composables.ChatListCard
import io.adik5050.discord_like.ui.app.chat_list.composables.ChatListSearchBar
import io.adik5050.discord_like.ui.theme.AppTheme

@Composable
fun ChatList(
    modifier: Modifier = Modifier,
    onClickToChatPage: () -> Unit
) {
    Surface (
        modifier = modifier,
        color = MaterialTheme.colorScheme.surfaceContainer
    ) {
        LazyColumn (
            modifier = Modifier.padding(16.dp)
        ) {
            item {
                ChatListSearchBar()
            }
            items (count = 15) {
                ChatListCard(
                    name = "Adi",
                    lastMessage = "Hello this is Adi",
                    onClick = onClickToChatPage
                )
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun PreviewChatList() {
    AppTheme {
        Surface {
            ChatList(
                onClickToChatPage = {}
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewChatListCard() {
    AppTheme (
        darkTheme = true
    ) {
        Surface {
            ChatList(
                onClickToChatPage = {}
            )
        }
    }
}