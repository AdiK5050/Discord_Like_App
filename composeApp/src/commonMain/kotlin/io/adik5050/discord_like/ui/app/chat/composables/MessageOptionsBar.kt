package io.adik5050.discord_like.ui.app.chat.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun MessageOptionsBar(
    modifier: Modifier = Modifier,
    optionList: List<MessageOption>,
    onClickOption: (Int) -> Unit
) {
    Card(
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            optionList.forEach {
                IconButton(
                    onClick = {
                        onClickOption(it.optionId)
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(it.icon),
                        contentDescription = stringResource(it.description)
                    )
                }
            }
        }
    }
}