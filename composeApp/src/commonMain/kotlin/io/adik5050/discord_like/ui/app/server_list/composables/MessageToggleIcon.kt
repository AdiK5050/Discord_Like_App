package io.adik5050.discord_like.ui.app.server_list.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.discord_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun MessageToggleIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card (
        modifier = modifier
            .padding(8.dp)
            .clickable(
                onClick = onClick
            ),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Icon(
            painterResource(Res.drawable.discord_logo),
            contentDescription = "Server Icon",
            modifier = Modifier
                .padding(8.dp)
                .size(48.dp)
        )
    }
}