package io.adik5050.discord_like.ui.app.chat_info.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.adik5050.discord_like.shared.composables.Image_With_Status
import io.adik5050.discord_like.shared.composables.OnlineStatus

@Composable
fun MembersCard(
    modifier: Modifier = Modifier,
    name: String,
    image: ByteArray?,
    status: OnlineStatus,
    about: String,
    activity: String,
    role: String,
    onClickProfile: () -> Unit
) {
    Row (
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image_With_Status(
                image = image,
                status = status,
                clickable = true,
                onClick = onClickProfile
            )
            Column (
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium
                )
                if(about.isNotBlank())
                    Text(
                        text = about,
                        style = MaterialTheme.typography.titleSmall
                    )
                if(activity.isNotBlank())
                    Text(
                        text = activity,
                        style = MaterialTheme.typography.titleSmall
                    )
            }
        }
        if(role.isNotBlank())
            Text(
                role,
                style = MaterialTheme.typography.titleMedium
            )
    }
}
