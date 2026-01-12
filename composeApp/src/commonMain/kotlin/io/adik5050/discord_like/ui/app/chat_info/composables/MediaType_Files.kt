package io.adik5050.discord_like.ui.app.chat_info.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.files_hollow
import myapplication.composeapp.generated.resources.key_board_arrow_down
import myapplication.composeapp.generated.resources.key_board_arrow_up
import org.jetbrains.compose.resources.painterResource

@Composable
fun MediaType_Files(
    modifier: Modifier = Modifier,
    numberOfFiles: Int = 378,
) {
    var expanded by remember { mutableStateOf(false) }
    Column {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    painter = painterResource(Res.drawable.files_hollow),
                    contentDescription = "Files"
                )

                Text(
                    text = "$numberOfFiles files"
                )
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
    }
}
