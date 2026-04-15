package io.adik5050.discord_like.shared.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.adik5050.discord_like.shared.composables.EmojiEntity
import kotlinx.coroutines.launch
import org.kodein.emoji.Emoji
import org.kodein.emoji.EmojiFinder
import org.kodein.emoji.EmojiTemplateCatalog
import org.kodein.emoji.allGroups
import org.kodein.emoji.allOf
import org.kodein.emoji.list

class EmojiSelectorViewmodel: ViewModel() {

    lateinit var allEmoji: List<Emoji>
    lateinit var emojiCatelog: EmojiTemplateCatalog
    lateinit var emojiFinder: EmojiFinder

    val allGroups = Emoji.allGroups().toList()
    val emojiSelectorTabOptions = mutableListOf<EmojiEntity>()


    init {
        viewModelScope.launch {
            allEmoji = Emoji.list()
            emojiCatelog = EmojiTemplateCatalog(allEmoji)
            emojiFinder = EmojiFinder()
        }
        allGroups.forEach { group ->
            val emoji = Emoji.allOf(group).firstOrNull()
            emoji?.let {
                emojiSelectorTabOptions.add(EmojiEntity(group, it))
            }
        }
    }
}