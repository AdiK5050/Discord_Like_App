package io.adik5050.discord_like.ui.app.home_page.composables

import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.shared.composables.OnlineStatus

@Composable
fun CompactHomePageBar(
    modifier: Modifier = Modifier,
    username: String,
    displayName: String,
    image: ImageBitmap? ,
    status: OnlineStatus = OnlineStatus.ONLINE,
    onClickProfile: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHoveredCard by interactionSource.collectIsHoveredAsState()
    OutlinedCard(
        modifier = modifier
            .hoverable(interactionSource),
        shape = (MaterialTheme.shapes.medium),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HomePageBarProfileCard(
                modifier = Modifier
                    .weight(1f),
                isHoveredCard = isHoveredCard,
                name = displayName,
                username = username,
                image = image,
                status = status,
                onClickProfile = onClickProfile
            )
            CompactHomePageBarButtons(
                onClickSettings = onClickProfile
            )
        }
    }
}