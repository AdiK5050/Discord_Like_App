package io.adik5050.discord_like.shared.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.adik5050.discord_like.shared.viewmodels.EmojiSelectorViewmodel
import org.kodein.emoji.Emoji
import org.kodein.emoji.allOf
import org.kodein.emoji.compose.WithPlatformEmoji

data class EmojiEntity(val string: String, val emoji: Emoji)
@Composable
fun EmojiSelector(
    modifier: Modifier,
    visibilityState: Boolean,
    height: Dp,
    bottomPadding: Dp,
    viewModel: EmojiSelectorViewmodel ,
    onClickEmoji: (Emoji) -> Unit,
) {
    var currentTab by remember { mutableStateOf(viewModel.emojiSelectorTabOptions.first()) }
    var currentTabEmojiList by remember { mutableStateOf(Emoji.allOf(currentTab.string)) }
    AnimatedVisibility(visibilityState) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            Column (
                modifier = modifier
                    .height(height)
                    .padding(16.dp)
                    .padding(bottom = bottomPadding)
                    .background(color = Color.Transparent, shape = MaterialTheme.shapes.medium),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                EmojiSelectorGroupTab(
                    listEmojiEntity = viewModel.emojiSelectorTabOptions,
                    onClickEmojiGroup = {
                        currentTab = it
                        currentTabEmojiList = Emoji.allOf(currentTab.string)
                    }
                )
                EmojiSelectorGroupEmojis(
                    emojiList = currentTabEmojiList,
                    onClickEmoji = onClickEmoji
                )
            }
        }
    }
}
@Composable
fun ClickableEmoji(
    modifier: Modifier = Modifier,
    emoji: Emoji,
    onClick: (Emoji) -> Unit
) {
    val interactionSource by remember { mutableStateOf(MutableInteractionSource()) }

    Card(
        modifier = modifier
            .padding(4.dp)
            .hoverable(
                interactionSource = interactionSource
            )
            .clickable(
                onClick = { onClick(emoji) }
            ),
        shape = MaterialTheme.shapes.extraSmall
    ) {
        if(emoji.details.hasNotoImage)
            WithPlatformEmoji(
                text = emoji.details.string
            ) { text, inlineContent ->
                Text(
                    text = text,
                    fontSize = 18.sp,
                    inlineContent = inlineContent
                )
            }
    }
}

@Composable
fun EmojiSelectorGroupEmojis(
    modifier: Modifier = Modifier,
    emojiList: List<Emoji>,
    onClickEmoji: (Emoji) -> Unit
) {
    val rowSize = 9
    var emojiColumns: List<List<Emoji>> by remember { mutableStateOf(emojiList.chunked(rowSize)) }

    LaunchedEffect(emojiList) {
        emojiColumns = emojiList.chunked(rowSize)
    }

    Card (
        modifier = modifier,
    ) {
        LazyColumn {
            items(emojiColumns) {
                Row {
                    it.forEach { emoji ->
                        ClickableEmoji(
                            emoji = emoji,
                            onClick = onClickEmoji
                        )
                    }
                }
            }
        }
    }
}
@Composable
fun EmojiSelectorGroupTab(
    modifier: Modifier = Modifier,
    listEmojiEntity: List<EmojiEntity>,
    onClickEmojiGroup: (EmojiEntity) -> Unit
) {
    Card (
        modifier = modifier
    ) {
        LazyRow {
            items(listEmojiEntity) { entity ->
                ClickableEmoji(
                    emoji = entity.emoji,
                    onClick = { onClickEmojiGroup(entity) }
                )
            }
        }
    }
}