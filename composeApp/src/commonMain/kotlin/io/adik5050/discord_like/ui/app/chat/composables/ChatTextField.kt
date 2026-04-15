package io.adik5050.discord_like.ui.app.chat.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.isAltPressed
import androidx.compose.ui.input.key.isCtrlPressed
import androidx.compose.ui.input.key.isMetaPressed
import androidx.compose.ui.input.key.isShiftPressed
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.attachment
import myapplication.composeapp.generated.resources.keyboard_icon
import myapplication.composeapp.generated.resources.send
import myapplication.composeapp.generated.resources.smiley
import org.jetbrains.compose.resources.painterResource

@Composable
fun ChatTextField(
    modifier: Modifier = Modifier,
    message: TextFieldValue,
    messagePlaceHolder: String?,
    showEmojiSelector: Boolean,
    textFieldHeight: Dp,
    onMessageChanged: (TextFieldValue) -> Unit,
    onClickSmiley: () -> Unit = {},
    onCLickSend: () -> Unit = {},
    onClickAttachment: () -> Unit = {}
) {
    OutlinedCard (
        modifier = modifier
            .fillMaxWidth(),
        shape = (MaterialTheme.shapes.medium),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Row (
            modifier = Modifier
                .heightIn(min = textFieldHeight),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                modifier = Modifier
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
            TextField (
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .onKeyEvent { event ->
                        if (event.key.keyCode == Key.Enter.keyCode &&
                            !event.isShiftPressed &&
                            !event.isCtrlPressed &&
                            !event.isAltPressed &&
                            !event.isMetaPressed) {
                            onCLickSend()
                            true
                        } else {
                            false
                        }
                    },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest.copy(alpha = 0.5f),
                    unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest.copy(alpha = 0.5f),
                    focusedIndicatorColor = MaterialTheme.colorScheme.surfaceContainerLowest.copy(alpha = 0.5f),
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.surfaceContainerLowest.copy(alpha = 0.5f)
                ),
                shape =  MaterialTheme.shapes.medium,
                maxLines = 16,
                value = message,
                onValueChange = {
                    onMessageChanged(it)
                },
                placeholder = {
                    Text(
                        text = "Message $messagePlaceHolder",
                        style = MaterialTheme.typography.labelMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            )

            IconButton (
                modifier = Modifier
                    .pointerHoverIcon(PointerIcon.Hand),
                shape = MaterialTheme.shapes.medium,
                onClick = onClickSmiley,
                content = {
                    Icon(
                        painter = if(showEmojiSelector) painterResource(Res.drawable.keyboard_icon) else painterResource(Res.drawable.smiley),
                        contentDescription = "Smiley",
                    )
                }
            )

            IconButton (
                modifier = Modifier
                    .pointerHoverIcon(PointerIcon.Hand),
                shape = MaterialTheme.shapes.medium,
                onClick = {
                    onCLickSend()
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
}