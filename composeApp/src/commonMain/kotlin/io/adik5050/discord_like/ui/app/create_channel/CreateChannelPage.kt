package io.adik5050.discord_like.ui.app.create_channel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.ui.app.create_channel.composables.CreateChannelHeader
import io.adik5050.discord_like.ui.app.create_channel.composables.CreateChannelMemberCardList
import io.adik5050.discord_like.ui.app.create_channel.composables.CreateChannelOptionsCard
import io.adik5050.discord_like.ui.theme.AppTheme

@Composable
fun CreateChannelPage(
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CreateChannelHeader(
            modifier = Modifier.padding(8.dp),
            onClickBack = {},
            onClickCreate = {},
            enableCreateButton = true
        )
        LazyColumn(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                CreateChannelOptionsCard(
                    onClickNewChannel = {},
                    onClickAddFriend = {}
                )
            }
            item {
                CreateChannelMemberCardList(

                    onClickCard = { memberId, selected ->

                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewCreateChannelPage() {
    AppTheme {
        Surface {
            CreateChannelPage()
        }
    }
}
@Preview
@Composable
fun PreviewDarkCreateChannelPage() {
    AppTheme (
        darkTheme = true
    ) {
        Surface {
            CreateChannelPage()
        }
    }
}
