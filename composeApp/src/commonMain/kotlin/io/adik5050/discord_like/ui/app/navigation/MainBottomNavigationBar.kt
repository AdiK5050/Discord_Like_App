package io.adik5050.discord_like.ui.app.navigation

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun MainBottomNavigationBar(
    modifier: Modifier,
    selectedKey: NavKey,
    onSelectKey: (NavKey)-> Unit
) {
    BottomAppBar(
        modifier = modifier
    ) {
        TOP_LEVEL_DESTINATIONS.forEach { (topLevelDestination, data ) ->
            NavigationBarItem(
                selected = topLevelDestination == selectedKey,
                onClick = {
                    onSelectKey(topLevelDestination)
                },
                icon = {
                    Icon(
                        painter = painterResource(data.icon),
                        contentDescription = stringResource(data.title)
                    )
                },
                label = {
                    Text(
                        text = stringResource(data.title)
                    )
                }
            )
        }
    }
}