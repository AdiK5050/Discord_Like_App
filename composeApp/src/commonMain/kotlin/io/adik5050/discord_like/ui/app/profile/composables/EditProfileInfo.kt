package io.adik5050.discord_like.ui.app.profile.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.shared.composables.OnlineStatus

@Composable
fun EditProfileInfo (
    modifier: Modifier = Modifier,
    username: String,
    displayName: String,
    pronouns: String?,
    image: ImageBitmap?,
    clickableImage: Boolean,
    onClickImage: () -> Unit,
    status: OnlineStatus,
    thoughts: String? = null,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        ProfileInfoImageRow(
            modifier,
            image = image,
            status = status,
            statusAlignment = Alignment.TopEnd,
            thoughts = thoughts,
            clickableImage = clickableImage,
            onClickImage = onClickImage,
        )
        ProfileInfoTextRow(
            modifier,
            displayName = displayName,
            username = username,
            pronouns = pronouns,
        )
    }
}