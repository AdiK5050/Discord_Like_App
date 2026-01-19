package io.adik5050.discord_like.ui.app.chat_info

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.ui.app.chat_info.composables.ChatInfoTopBar
import io.adik5050.discord_like.ui.app.chat_info.composables.MediaInfo
import io.adik5050.discord_like.ui.app.chat_info.composables.MembersInfo
import io.adik5050.discord_like.ui.theme.AppTheme

@Composable
fun ChatInfo(
    modifier: Modifier = Modifier
) {
    Surface (
        modifier = modifier
            .fillMaxSize(),
    ) {
        Column (
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ChatInfoTopBar()
            MembersInfo(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.75f)
            )
            MediaInfo(
                modifier = Modifier
                    .weight(0.5f)
            )
        }
    }
}

@Preview
@Composable
fun PreviewChatInfo() {
    AppTheme {
        Surface {
            ChatInfo()
        }
    }
}
@Preview
@Composable
fun PreviewChatInfoDark() {
    AppTheme (darkTheme = true){
        Surface {
            ChatInfo()
        }
    }
}
