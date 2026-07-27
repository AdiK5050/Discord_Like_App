package io.adik5050.discord_like.ui.app.home_page.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.bottom_navigation_setting
import myapplication.composeapp.generated.resources.discord_settings
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun CompactHomePageBarButtons(
    onClickSettings: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End)
    ) {
//        IconButton(
//            onClick = onClickNotifications,
//            content = {
//                Icon(
//                    modifier = Modifier
//                        .sizeIn(maxWidth = 24.dp, maxHeight = 24.dp)
//                        .alpha(1f),
//                    painter = painterResource(Res.drawable.discord_notifications),
//                    contentDescription = stringResource(Res.string.bottom_navigation_notifications)
//                )
//            }
//        )
        IconButton(
            onClick = onClickSettings,
            content = {
                Icon(
                    modifier = Modifier
                        .sizeIn(maxWidth = 24.dp, maxHeight = 24.dp)
                        .alpha(1f),
                    painter = painterResource(Res.drawable.discord_settings),
                    contentDescription = stringResource(Res.string.bottom_navigation_setting)
                )
            }
        )
    }
}