package io.adik5050.discord_like.ui.app.create_channel.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import io.adik5050.discord_like.shared.composables.UserCard
import io.adik5050.discord_like.ui.app.create_channel.viewmodels.ModUserInfo

@Composable
fun CreateChannelUserCardList(
    modifier: Modifier = Modifier,
    userList: List<ModUserInfo>,
    onClickCard: (memberId: Int, selected: Boolean) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = modifier
        ) {
            userList.forEach { user ->
                var selected by remember { mutableStateOf(false) }
                UserCard(
                    username = user.username,
                    displayName = user.displayName,
                    image = user.profileImage,
                    useToggle = true,
                    selected = selected,
                    clickable = true,
                    onClick = { previousState ->
                        selected = !previousState
                        onClickCard(user.userId, selected)
                    }
                )
            }
        }
    }
}