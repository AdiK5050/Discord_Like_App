package io.adik5050.discord_like.ui.app.chat_page.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.shared.composables.Image_With_Status
import io.adik5050.discord_like.shared.composables.OnlineStatus
import io.adik5050.discord_like.ui.theme.AppTheme
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.search
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ChatList(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Surface (
        modifier = modifier,
        color = MaterialTheme.colorScheme.surfaceContainer
    ) {
        LazyColumn (
            modifier = Modifier.padding(16.dp)
        ) {
            item {
                SearchBar()
            }
            items (count = 15) {
                ChatCard(
                    name = "Adi",
                    lastMessage = "Hello this is Adi",
                    onClick = onClick
                )
            }
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {} ,
        modifier = modifier
            .padding(8.dp),
        shape = MaterialTheme.shapes.large,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                modifier = Modifier
                    .padding(8.dp)
                    .size(32.dp),
                painter = painterResource(Res.drawable.search),
                contentDescription = "Search"
            )
            Text(
                text = stringResource(Res.string.search),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
@Composable
fun ChatCard(
    modifier: Modifier = Modifier,
    image: ByteArray? = null,
    status: OnlineStatus = OnlineStatus.ONLINE,
    name: String,
    lastMessage: String,
    onClick: () -> Unit
) {
    Card (
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image_With_Status(
                image = image,
                status = status,
                clickable = false,
                onClick = {}
            )
            Column (
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = lastMessage,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewChatList() {
    AppTheme {
        Surface {
            ChatList()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewChatListCard() {
    AppTheme (
        darkTheme = true
    ) {
        Surface {
            ChatList()
        }
    }
}