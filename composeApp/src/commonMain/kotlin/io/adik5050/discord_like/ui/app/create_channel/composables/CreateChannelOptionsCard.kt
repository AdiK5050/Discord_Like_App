package io.adik5050.discord_like.ui.app.create_channel.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.add_friend
import myapplication.composeapp.generated.resources.group_add
import myapplication.composeapp.generated.resources.keyboard_arrow_right
import myapplication.composeapp.generated.resources.new_channel
import myapplication.composeapp.generated.resources.person_add
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun CreateChannelOptionsCard(
    modifier: Modifier = Modifier,
    onClickNewChannel: () -> Unit,
    onClickAddFriend: () -> Unit
) {
    Card (
        shape = MaterialTheme.shapes.large
    ) {
        Column {
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .size(40.dp)
                            .padding(8.dp),
                        painter = painterResource(Res.drawable.group_add),
                        contentDescription = stringResource(Res.string.new_channel),
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = stringResource(Res.string.new_channel),
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        IconButton(
                            onClick = onClickNewChannel,
                        ) {
                            Icon(
                                painter = painterResource(Res.drawable.keyboard_arrow_right),
                                contentDescription = "Arrow Next"
                            )
                        }
                    }
                }
            }
            HorizontalDivider(
                modifier = Modifier
                    .padding(start = 56.dp)
                    .align(Alignment.End)
            )
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colorScheme.tertiaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .size(40.dp)
                            .padding(8.dp),
                        painter = painterResource(Res.drawable.person_add),
                        contentDescription = stringResource(Res.string.add_friend),
                        tint = MaterialTheme.colorScheme.onTertiaryContainer
                    )

                }
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = stringResource(Res.string.add_friend),
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        IconButton(
                            onClick = onClickAddFriend,
                        ) {
                            Icon(
                                painter = painterResource(Res.drawable.keyboard_arrow_right),
                                contentDescription = "Arrow Next"
                            )
                        }
                    }
                }
            }
        }
    }
}