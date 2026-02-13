package io.adik5050.discord_like.ui.app.home_page.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.shared.composables.ImageWithStatus
import io.adik5050.discord_like.shared.composables.OnlineStatus

@Composable
fun HomePageBarProfileCard(
    modifier: Modifier = Modifier,
    isHoveredCard: Boolean,
    name: String,
    username: String,
    image: ByteArray?,
    status: OnlineStatus,
    onClickProfile: () -> Unit
) {
    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(10))
            .clickable(
                onClick = onClickProfile
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ImageWithStatus(
            modifier = Modifier
                .padding(2.dp)
                .size(56.dp),
            image = image,
            status = status,
            clickable = false,
            onClick = { },
        )
        Column(
            modifier = Modifier.padding(4.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge
            )
            AnimatedVisibility(!isHoveredCard) {
                Text(
                    text = status.name.lowercase()
                        .replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() },
                    style = MaterialTheme.typography.labelLarge
                )
            }
            AnimatedVisibility(isHoveredCard) {
                Text(
                    text = username,
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}