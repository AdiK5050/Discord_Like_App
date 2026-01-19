package io.adik5050.discord_like.ui.app.home_page

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.ui.app.chat_list.ChatList
import io.adik5050.discord_like.ui.app.server_list.ServerList
import io.adik5050.discord_like.ui.theme.AppTheme


@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    onClickMessageIcon: () -> Unit,
    onClickChatPage: () -> Unit
) {
    Row (
        modifier = modifier
            .fillMaxSize(),
    ) {
        ServerList(
            modifier = Modifier
                .width(80.dp),
            onClickMessageIcon = onClickMessageIcon
        )
        Surface (
            shape = MaterialTheme.shapes.large
        ){
            Row {
                ChatList(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .weight(0.30f),
                    onClickToChatPage = onClickChatPage
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewChatPage() {
    AppTheme {
        Surface {
            HomePage(
                onClickMessageIcon = {}
            ) {}
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewChatPageDark() {
    AppTheme (
        darkTheme = true
    ) {
        Surface {
            HomePage(
                onClickMessageIcon = {}
            ) {}
        }
    }
}