package io.adik5050.discord_like.ui.app.chat_info.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.shared.composables.OnlineStatus

@Composable
fun MembersInfo (
    modifier: Modifier = Modifier,
    onClickAddNew: () -> Unit = {}
) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Members",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
            )
            Text(
                modifier = Modifier
                    .clickable(
                        onClick = onClickAddNew
                    ),
                text = "Add New",
                style = MaterialTheme.typography.titleMedium
            )
        }
        LazyColumn (
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            item {
                MembersCard(
                    name = "Richard Wilson",
                    image = null,
                    status = OnlineStatus.ONLINE,
                    about = "playing NFS Heat",
                    activity = "",
                    role = "Admin",
                    onClickProfile = {}
                )
            }
            items(5) {
                MembersCard(
                    name = "Jenna Oritz",
                    image = null,
                    status = OnlineStatus.ONLINE,
                    about = "",
                    activity = "",
                    role = "",
                    onClickProfile = {}
                )
            }
            items(5) {
                MembersCard(
                    name = "Jenna Oritz",
                    image = null,
                    status = OnlineStatus.DO_NOT_DISTURB,
                    about = "",
                    activity = "",
                    role = "",
                    onClickProfile = {}
                )
            }
        }
    }
}
