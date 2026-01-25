package io.adik5050.discord_like.ui.app.navigation.main

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
        Row{
            TOP_LEVEL_DESTINATIONS.forEach { (topLevelDestination, data ) ->
                NavigationBarItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(24.dp)
                        .weight(1f),
                    icon = {
                        var alpha by remember { mutableStateOf(1.5f) }
                        if(selectedKey == topLevelDestination) alpha = 1.5f else alpha = 0.5f
                        Icon(
                            painter = painterResource(data.icon),
                            contentDescription = stringResource(data.title),
                            modifier = Modifier
                                .alpha(alpha)
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(data.title),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.labelSmall
                        )
                    },
                    selected = false,
                    onClick = {
                        onSelectKey(topLevelDestination)
                    }
                )
            }
        }
    }
}
/* Didn't turn out to be good and reliable */

//@Composable
//fun BottomBarItem(
//    modifier: Modifier = Modifier,
//    icon: DrawableResource,
//    label: StringResource,
//    selected: Boolean,
//    onClick: () -> Unit
//) {
//    Box(
//        modifier = modifier,
//        contentAlignment = Alignment.Center,
//    ) {
//
//            var alpha by remember { mutableStateOf(1.5f) }
//            if(selected) alpha = 1.5f else alpha = 0.5f
//            IconButton(
//                onClick = onClick,
//                content = {
//                    Column(
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Icon(
//                            painter = painterResource(icon),
//                            contentDescription = stringResource(label),
//                            modifier = Modifier
//                                .alpha(alpha)
//                        )
//                        Text(
//                            text = stringResource(label),
//                            textAlign = TextAlign.Center,
//                            style = MaterialTheme.typography.labelSmall
//                        )
//                    }
//                }
//            )
//            Icon(
//                painter = painterResource(icon),
//                contentDescription = stringResource(label),
//                modifier = Modifier
//                    .alpha(alpha)
//                    .clickable(
//                    onClick = onClick
//                ),
//            )
//            Text(
//                text = stringResource(label),
//                textAlign = TextAlign.Center,
//                style = MaterialTheme.typography.labelSmall
//            )
//    }
//}