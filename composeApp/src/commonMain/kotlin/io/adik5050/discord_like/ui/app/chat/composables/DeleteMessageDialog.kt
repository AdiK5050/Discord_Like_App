package io.adik5050.discord_like.ui.app.chat.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.cancel_button
import myapplication.composeapp.generated.resources.confirm_button
import myapplication.composeapp.generated.resources.delete
import myapplication.composeapp.generated.resources.delete_message_dialog_title
import myapplication.composeapp.generated.resources.message_option_delete
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteMessageDialog(
    onCancel: () -> Unit,
    onConfirm: () -> Unit,
    displayName: String?,
    message: String?,
) {
    AlertDialog(
        onDismissRequest = onCancel,
        confirmButton = {
            Button(
                onClick = onConfirm
            ) {
                Text(
                    text = stringResource(Res.string.confirm_button)
                )
            }
        },
        dismissButton = {
            Button(
                onClick = onCancel
            ) {
                Text(
                    text = stringResource(Res.string.cancel_button)
                )
            }
        },
        icon = {
            Icon(
                painter = painterResource(Res.drawable.delete),
                contentDescription = stringResource(Res.string.message_option_delete),
                tint = MaterialTheme.colorScheme.error
            )
        },
        title = {
            Text(
                text = stringResource(Res.string.delete_message_dialog_title)
            )
        },
        text = {
            Column (
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = displayName ?: "Couldn't load name",
                    style = MaterialTheme.typography.labelMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = message?: "Couldn't load message",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    )
}