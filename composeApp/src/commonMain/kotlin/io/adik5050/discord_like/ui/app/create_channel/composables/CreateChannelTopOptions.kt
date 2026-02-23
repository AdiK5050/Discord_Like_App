package io.adik5050.discord_like.ui.app.create_channel.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.arrow_back_24dp_e3e3e3_fill0_wght400_grad0_opsz24
import myapplication.composeapp.generated.resources.create
import myapplication.composeapp.generated.resources.new_channel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun CreateChannelHeader(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit,
    enableCreateButton: Boolean,
    onClickCreate: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = onClickBack,
        ) {
            Icon(
                painter = painterResource(Res.drawable.arrow_back_24dp_e3e3e3_fill0_wght400_grad0_opsz24),
                contentDescription = "Back"
            )
        }
        Text(
            text = stringResource(Res.string.new_channel),
            style = MaterialTheme.typography.headlineSmall
        )
        Button(
            onClick = onClickCreate,
            enabled = enableCreateButton,
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = MaterialTheme.colorScheme.primaryFixedDim,
                disabledContentColor = MaterialTheme.colorScheme.onPrimaryFixed
            )
        ) {
            Text(
                text = stringResource(Res.string.create)
            )
        }
    }
}