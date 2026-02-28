package io.adik5050.discord_like.shared.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import io.adik5050.discord_like.ui.app.navigation.Route
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.bottom_navigation_home
import myapplication.composeapp.generated.resources.bottom_navigation_notifications
import myapplication.composeapp.generated.resources.bottom_navigation_profile
import myapplication.composeapp.generated.resources.discord_home
import myapplication.composeapp.generated.resources.discord_settings
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun BottomNavigation (
    modifier: Modifier = Modifier,
    image: ImageBitmap?,
    selectedKey: NavKey,
    onSelectedKey: (NavKey) -> Unit,
) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.navigationBars),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        NavigationBarItem(
            icon = {
                var alpha by remember { mutableStateOf(1f) }
                alpha = if(selectedKey == Route.Home) 1f else 0.5f
                Icon(
                    painter = painterResource(Res.drawable.discord_home),
                    contentDescription = stringResource(Res.string.bottom_navigation_home),
                    modifier = Modifier.alpha(alpha)
                )
            },
            label = {
                Text(
                    text = stringResource(Res.string.bottom_navigation_home),
                    style = MaterialTheme.typography.labelSmall,
                    fontSize = 10.sp
                    )
            },
            selected = false,
            onClick = {
                onSelectedKey(Route.Home)
            }
        )
        NavigationBarItem(
            icon = {
                var alpha by remember { mutableStateOf(1f) }
                alpha = if(selectedKey == Route.Settings) 1f else 0.5f
                Icon(
                    painter = painterResource(Res.drawable.discord_settings),
                    contentDescription = stringResource(Res.string.bottom_navigation_notifications),
                    modifier = Modifier.alpha(alpha)
                )
            },
            label = {
                Text(
                    text = stringResource(Res.string.bottom_navigation_notifications),
                    style = MaterialTheme.typography.labelSmall,
                    fontSize = 10.sp
                )
            },
            selected = false,
            onClick = {
                onSelectedKey(Route.Settings)
            }
        )
        NavigationBarItem(
            icon = {
                ImageWithStatus (
                    modifier = Modifier
                        .size(24.dp),
                    image = image,
                    clickable = true,
                    onClick = {
                        onSelectedKey(Route.Profile)
                    }
                )
            },
            label = {
                Text(
                    text = stringResource(Res.string.bottom_navigation_profile),
                    style = MaterialTheme.typography.labelSmall,
                    fontSize = 10.sp
                )
            },
            selected = false,
            onClick = {
                onSelectedKey(Route.Profile)
            }
        )
    }
}