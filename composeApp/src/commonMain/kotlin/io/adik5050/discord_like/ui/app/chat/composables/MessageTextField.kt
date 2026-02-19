package io.adik5050.discord_like.ui.app.chat.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
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
    messagePlaceHolder: String= "@Adi",
    onClickAttachment: () -> Unit = {},
    onClickSmiley: () -> Unit = {},
    onCLickSend: (String) -> Unit = {},
) {
    var message by rememberSaveable(stateSaver = TextFieldValue.Saver) { mutableStateOf(TextFieldValue("")) }

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .border(width = 0.2.dp,
                color = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
                shape =  MaterialTheme.shapes.medium),
        shape =  MaterialTheme.shapes.medium,
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surfaceContainer,
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainer,
            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        ),
        maxLines = 16,
        value = message,
        onValueChange = { newValue ->
            message = newValue
        },
        placeholder = {
            Text(
                text = "Message $messagePlaceHolder",
                style = MaterialTheme.typography.labelLarge
            )
        },
        leadingIcon = {
            IconButton(
                modifier = Modifier
                    .padding(8.dp)
                    .pointerHoverIcon(PointerIcon.Hand),
                shape = MaterialTheme.shapes.medium,
                onClick = onClickAttachment,
                content = {
                    Icon(
                        painter = painterResource(Res.drawable.attachment),
                        contentDescription = "Attachment",
                    )
                }
            )
        },
        trailingIcon = {
            Row {
                IconButton(
                    modifier = Modifier
                        .padding(8.dp)
                        .pointerHoverIcon(PointerIcon.Hand),
                    shape = MaterialTheme.shapes.medium,
                    onClick = onClickSmiley,
                    content = {
                        Icon(
                            painter = painterResource(Res.drawable.smiley),
                            contentDescription = "Smiley",
                        )
                    }
                )
                IconButton(
                    modifier = Modifier
                        .padding(8.dp)
                        .pointerHoverIcon(PointerIcon.Hand),
                    shape = MaterialTheme.shapes.medium,
                    onClick = {
                        onCLickSend(message.text)
                    },
                    content = {
                        Icon(
                            painter = painterResource(Res.drawable.send),
                            contentDescription = "Send",
                        )
                    }
                )
            }
        }
    )
}