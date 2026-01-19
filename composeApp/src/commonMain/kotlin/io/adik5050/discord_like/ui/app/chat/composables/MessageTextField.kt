package io.adik5050.discord_like.ui.app.chat.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.attachment
import myapplication.composeapp.generated.resources.send
import myapplication.composeapp.generated.resources.smiley
import org.jetbrains.compose.resources.painterResource

@Composable
fun MessageTextField(
    modifier: Modifier = Modifier,
    onClickAttachment: () -> Unit = {},
    onClickSmiley: () -> Unit = {},
    onCLickSend: (String) -> Unit = {},
) {
    var message by rememberSaveable(stateSaver = TextFieldValue.Saver) { mutableStateOf(TextFieldValue("")) }

    TextField(
        modifier = modifier
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.small,
        value = message,
        onValueChange = { newValue ->
            message = newValue
        },
        placeholder = {
            Text(
                text = "Write a message...",
                style = MaterialTheme.typography.bodyMedium
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(Res.drawable.attachment),
                contentDescription = "Attachment",
                modifier = Modifier.clickable(
                    onClick = onClickAttachment
                )
            )
        },
        trailingIcon = {
            Row {
                Icon(
                    painter = painterResource(Res.drawable.smiley),
                    contentDescription = "Smiley",
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable(
                        onClick = onClickSmiley
                    )
                )
                Spacer(modifier = Modifier.size(8.dp))
                Icon(
                    painter = painterResource(Res.drawable.send),
                    contentDescription = "Send",
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable(
                        onClick = {
                            onCLickSend(message.text)
                            message = TextFieldValue("")
                        }
                    )
                )
            }
        }
    )
}