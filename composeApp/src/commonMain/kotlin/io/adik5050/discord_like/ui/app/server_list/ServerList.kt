package io.adik5050.discord_like.ui.app.server_list

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.ui.app.server_list.composables.MessageToggleIcon
import io.adik5050.discord_like.ui.app.server_list.composables.ServerIcon
import io.adik5050.discord_like.ui.theme.AppTheme

@Composable
fun ServerList(
    modifier: Modifier = Modifier,
    onClickMessageIcon: () -> Unit
) {
    LazyColumn (
        modifier = modifier,
    ) {
        item {
            MessageToggleIcon(
                onClick = onClickMessageIcon
            )
            Spacer(modifier = Modifier.size(16.dp))
        }
        items(count = 15) {
            ServerIcon()
        }
    }
}





@Preview(showBackground = true)
@Composable
fun PreviewServerListLight() {
    AppTheme {
        Surface {
            ServerList(
                onClickMessageIcon = {})
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewServerListDark() {
    AppTheme (
        darkTheme = true
    ) {
        Surface {
            ServerList(
                onClickMessageIcon = {}
            )
        }
    }
}
