package io.adik5050.discord_like.shared.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.check_box_blank
import myapplication.composeapp.generated.resources.check_box_filled
import org.jetbrains.compose.resources.painterResource

@Composable
fun UserCard(
    modifier: Modifier = Modifier,
    username: String,
    displayName: String?,
    image: ImageBitmap?,
    useToggle: Boolean = false,
    selected: Boolean = false,
    clickable: Boolean = false,
    onClick: (Boolean) -> Unit= {},
) {
    Column(
        modifier = modifier
            .clickable(
                enabled = clickable,
                onClick = {
                    onClick(selected)
                }
            )
    ) {
        Row(
            modifier = Modifier
                .padding(end = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageWithStatus(
                    modifier = Modifier
                        .padding(4.dp),
                    image = image
                )
                Column {
                    Text(
                        text = displayName?:"",
                        style = MaterialTheme.typography.titleSmall,
                        textAlign = TextAlign.Start,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier
                            .alpha(0.8f),
                        text = username,
                        style = MaterialTheme.typography.bodySmall,
                        textAlign = TextAlign.Start,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            if(useToggle) {
                if(selected) {
                    Icon(
                        painter = painterResource(Res.drawable.check_box_filled),
                        contentDescription = "Selected",
                        tint = MaterialTheme.colorScheme.primary
                    )
                } else {
                    Icon(
                        painter = painterResource(Res.drawable.check_box_blank),
                        contentDescription = "Not Selected",
                    )
                }
            }
        }
        HorizontalDivider(
            modifier = Modifier
                .padding(start = 56.dp)
                .align(Alignment.End)
        )
    }
}