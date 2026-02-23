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
import com.wannaverse.imageselector.toImageBitmap
import io.adik5050.discord_like.shared.composables.MemberCard
import io.adik5050.discord_like.ui.app.chat.viewmodels.RawUserInfo

@Composable
fun CreateChannelMemberCardList(
    modifier: Modifier = Modifier,
    memberList: List<RawUserInfo>,
    onClickCard: (memberId: Int, selected: Boolean) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = modifier
        ) {
            memberList.forEach { user ->
                var selected by remember { mutableStateOf(false) }
                MemberCard(
                    username = user.username,
                    displayName = user.displayName,
                    image = user.profileImage?.toImageBitmap(),
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