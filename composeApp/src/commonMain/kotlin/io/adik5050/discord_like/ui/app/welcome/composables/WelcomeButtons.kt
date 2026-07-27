package io.adik5050.discord_like.ui.app.welcome.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.login
import myapplication.composeapp.generated.resources.register
import org.jetbrains.compose.resources.stringResource

@Composable
fun WelcomeButtons(
    modifier: Modifier = Modifier,
    onClickRegister: () -> Unit,
    onClickLogin: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onClickRegister,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainer,
            ),
            content = {
                Text(
                    text = stringResource(Res.string.register),
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        )
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = onClickLogin,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
            ),
            content = {
                Text(
                    text = stringResource(Res.string.login),
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        )
    }
}