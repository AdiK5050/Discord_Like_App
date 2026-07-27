package io.adik5050.discord_like.ui.app.profile.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.arrow_back
import myapplication.composeapp.generated.resources.save
import myapplication.composeapp.generated.resources.save_icon
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun EditProfileTopOptions(
    onNavigateBack: () -> Unit,
    onSave: () -> Unit,
    showSave: Boolean,
) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = onNavigateBack,
            content = {
                Icon(
                    painter = painterResource(Res.drawable.arrow_back),
                    contentDescription = "Back"
                )
            }
        )
        IconButton(
            onClick = onSave,
            enabled = showSave,
            content = {
                Icon(
                    painter = painterResource(Res.drawable.save),
                    contentDescription = stringResource(Res.string.save_icon)
                )
            }
        )
    }
}