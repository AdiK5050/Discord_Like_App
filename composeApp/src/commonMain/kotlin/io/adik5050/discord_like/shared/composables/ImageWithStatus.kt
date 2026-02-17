package io.adik5050.discord_like.shared.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wannaverse.imageselector.toImageBitmap
import com.wannaverse.imageselector.withAspectRatio
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.discord
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ImageWithStatus(modifier: Modifier = Modifier,
                    image: ByteArray?,
                    status: OnlineStatus,
                    statusAlignment: Alignment = Alignment.BottomEnd,
                    clickable: Boolean = false,
                    onClick: () -> Unit= {}
) {
    Box (
        modifier = modifier
    ) {
        Box (
            modifier = Modifier
                .clip(CircleShape)
                .clickable (
                    clickable,
                    onClick = { onClick() }
                )
        ) {
            image?.let {
                Image(
                    bitmap = image.toImageBitmap().withAspectRatio(1f / 1f),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                )
            } ?:
                Image(
                    painterResource(Res.drawable.discord),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                )
        }
        Box(
            modifier = Modifier
                .align(statusAlignment)
                .border(width = 4.dp, color = MaterialTheme.colorScheme.background, shape = CircleShape)
                .background(color = MaterialTheme.colorScheme.background,shape = CircleShape)
        ) {
            Icon(
                painter = painterResource(status.icon),
                contentDescription = stringResource(status.description),
                tint = status.color
            )
        }
    }
}



@Preview
@Composable
fun Preview_Image_With_Status() {
    MaterialTheme(darkColorScheme()) {
        Surface {
            Column {
                ImageWithStatus(
                    image = null,
                    status = OnlineStatus.ONLINE,
                    statusAlignment = Alignment.BottomEnd
                    )
                ImageWithStatus(
                    image = null,
                    status = OnlineStatus.DO_NOT_DISTURB,
                    statusAlignment = Alignment.BottomEnd
                    )
                ImageWithStatus(
                    image = null,
                    status = OnlineStatus.OFFLINE,
                    statusAlignment = Alignment.BottomEnd
                    )
            }
        }
    }
}