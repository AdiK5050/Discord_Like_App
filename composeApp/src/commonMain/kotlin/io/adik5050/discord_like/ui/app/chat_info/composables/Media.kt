package io.adik5050.discord_like.ui.app.chat_info.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.shared.composables.ImageCard
import io.adik5050.discord_like.ui.app.home_page.composables.MediaType
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.key_board_arrow_down
import myapplication.composeapp.generated.resources.key_board_arrow_up
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun Media(
    modifier: Modifier = Modifier,
    contentIcon: DrawableResource,
    contentType: MediaType,
    numberOfSharedContent: Int,
) {
    var expanded by remember { mutableStateOf(false) }
    Column (
        modifier = modifier
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    painter = painterResource(contentIcon),
                    contentDescription = "Photos"
                )
                Text("$numberOfSharedContent $contentType")
            }
            IconButton(
                onClick = {
                    expanded = !expanded
                },
                content = {
                    if(expanded)
                        Icon(
                            painter = painterResource(Res.drawable.key_board_arrow_down),
                            contentDescription = "Expand"
                        )
                    else
                        Icon(
                            painter = painterResource(Res.drawable.key_board_arrow_up),
                            contentDescription = "Expand"
                        )
                }
            )
        }
        if(expanded)
            LazyRow (
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(count = 5) {
                    ImageCard(
                        modifier
                            .heightIn(max = 100.dp)
                            .widthIn(max = 200.dp),
                        image = null
                    )
                }
            }
    }
}