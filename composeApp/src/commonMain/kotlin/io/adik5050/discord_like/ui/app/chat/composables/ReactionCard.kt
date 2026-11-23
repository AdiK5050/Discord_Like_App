package io.adik5050.discord_like.ui.app.chat.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.storage.ReactionEntity

@Composable
fun ReactionCard(
    ownUserId: Int,
    reactions: List<ReactionEntity>,
    onClickReaction: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val groupedReactions = remember(reactions) { reactions.groupBy { it.reaction } }

    CompositionLocalProvider(LocalMinimumInteractiveComponentSize provides Dp.Unspecified) {
        FlowRow(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            groupedReactions.forEach { reaction ->
                key(reaction.key) {
                    val interactionSource = remember { MutableInteractionSource() }
                    val isHovered by interactionSource.collectIsHoveredAsState()
                    val isReactionOwn = reaction.value.any { it.senderId == ownUserId }

                    val borderColor = when {
                        isReactionOwn -> MaterialTheme.colorScheme.primary
                        isHovered -> MaterialTheme.colorScheme.outline
                        else -> MaterialTheme.colorScheme.outlineVariant
                    }

                    Card(
                        onClick = { onClickReaction(reaction.key) },
                        colors = CardDefaults.cardColors(
                            containerColor = if (isReactionOwn) {
                                MaterialTheme.colorScheme.secondaryContainer
                            } else {
                                MaterialTheme.colorScheme.surfaceContainerHigh
                            }
                        ),
                        shape = MaterialTheme.shapes.small,
                        border = BorderStroke(1.dp, borderColor),
                        interactionSource = interactionSource
                    ) {
                        Text(
                            text = "${reaction.key} ${reaction.value.size}",
                            style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
            }
        }
    }
}
