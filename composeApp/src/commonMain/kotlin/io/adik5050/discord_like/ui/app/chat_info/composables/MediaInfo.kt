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
import io.adik5050.discord_like.ui.app.home_page.composables.MediaType
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.files_hollow
import myapplication.composeapp.generated.resources.link_hollow
import myapplication.composeapp.generated.resources.photo_library_hollow

@Composable
fun MediaInfo(
    modifier: Modifier = Modifier,
    onClickViewAll: () -> Unit = {}
) {
    Column (
        modifier = modifier
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Files",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier
                    .clickable(
                        onClick = onClickViewAll
                    ),
                text = "View All",
                style = MaterialTheme.typography.titleMedium
            )
        }
        LazyColumn {
            item {
                Media(
                    contentIcon = Res.drawable.photo_library_hollow,
                    contentType = MediaType.Photos,
                    numberOfSharedContent = 295,
                )
                Media(
                    contentIcon = Res.drawable.files_hollow,
                    contentType = MediaType.Files,
                    numberOfSharedContent = 378,
                )
                Media(
                    contentIcon = Res.drawable.link_hollow,
                    contentType = MediaType.Links,
                    numberOfSharedContent = 45,
                )
            }
        }
    }
}
