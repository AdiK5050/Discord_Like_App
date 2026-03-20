package io.adik5050.discord_like.ui.app.chat.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.content_copy
import myapplication.composeapp.generated.resources.delete
import myapplication.composeapp.generated.resources.edit
import myapplication.composeapp.generated.resources.forward
import myapplication.composeapp.generated.resources.message_option_copy
import myapplication.composeapp.generated.resources.message_option_delete
import myapplication.composeapp.generated.resources.message_option_edit
import myapplication.composeapp.generated.resources.message_option_forward
import myapplication.composeapp.generated.resources.message_option_reply
import myapplication.composeapp.generated.resources.reply
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageOptionsBottomSheet(
    onDismissRequest: () -> Unit,
    ownMessage: Boolean,
    onClickOption: (Int) -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest
    ) {
        LazyColumn (
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                MessageOptionCard(
                    contentList = if(ownMessage) ownMessageOptions else otherMessageOptions,
                    onClickOption = onClickOption
                )
            }
        }
    }
}

@Composable
fun MessageOptionCard(
    modfiier: Modifier = Modifier,
    contentList: List<MessageOption>,
    onClickOption: (Int) -> Unit
) {
    Card(
        modifier = modfiier
    ) {
        Column {
            contentList.forEach {
                MessageOption(
                    label = it.description,
                    icon =  it.icon,
                    onClick = {
                        onClickOption(it.optionId)
                    }
                )
            }
        }
    }
}

@Composable
fun MessageOption(
    modifier: Modifier = Modifier,
    label: StringResource,
    icon: DrawableResource,
    onClick: () -> Unit,
) {
    Box (
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                onClick = onClick
            )
    ) {
        Row(
            modifier = modifier
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(32.dp)
                    .padding(8.dp),
                painter = painterResource(icon),
                contentDescription = stringResource(label)
            )
            Text(
                text = stringResource(label),
                style = MaterialTheme.typography.labelLarge,
            )
        }
    }
}

enum class MessageOption(val optionId: Int, val icon: DrawableResource, val description: StringResource) {
    EDIT(optionId = 1, icon = Res.drawable.edit, description = Res.string.message_option_edit),
    REPLY(optionId = 2, icon = Res.drawable.reply, description = Res.string.message_option_reply),
    FORWARD(optionId = 3, icon = Res.drawable.forward, description = Res.string.message_option_forward),
    COPY(optionId = 4, icon = Res.drawable.content_copy, description = Res.string.message_option_copy),
    DELETE(optionId = 5, icon = Res.drawable.delete, description = Res.string.message_option_delete)
}

val allMessageOptions = listOf(
    MessageOption.EDIT,
    MessageOption.REPLY,
    MessageOption.FORWARD,
    MessageOption.COPY,
    MessageOption.DELETE
)
val ownMessageOptions = listOf(
    MessageOption.EDIT,
    MessageOption.REPLY,
    MessageOption.FORWARD,
    MessageOption.COPY,
    MessageOption.DELETE
)

val otherMessageOptions = listOf(
    MessageOption.REPLY,
    MessageOption.FORWARD,
    MessageOption.COPY
)