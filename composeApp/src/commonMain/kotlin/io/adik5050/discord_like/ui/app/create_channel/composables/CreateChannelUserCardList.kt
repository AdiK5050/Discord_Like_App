package io.adik5050.discord_like.ui.app.create_channel.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import io.adik5050.discord_like.shared.composables.UserCard
import io.adik5050.discord_like.ui.app.chat.viewmodels.UserInfo
import io.adik5050.discord_like.ui.app.create_channel.viewmodels.EntityImage

@Composable
fun CreateChannelUserCardList(
    modifier: Modifier = Modifier,
    userInfoList: List<UserInfo>,
    entityImageList: SnapshotStateList<EntityImage>,
    onClickCard: (memberId: Int, selected: Boolean) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = modifier
        ) {
            for(user in userInfoList) {
                var selected by remember { mutableStateOf(false) }
                var image: ImageBitmap? by remember { mutableStateOf(null) }
                entityImageList
                    .forEach { entity ->
                        if(entity.entityId == user.userId) {
                            image = entity.image
                        }
                    }
                UserCard(
                    username = user.username,
                    displayName = user.displayName,
                    image = image,
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