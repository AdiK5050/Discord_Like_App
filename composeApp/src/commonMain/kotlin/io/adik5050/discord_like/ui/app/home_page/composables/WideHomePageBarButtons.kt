package io.adik5050.discord_like.ui.app.home_page.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.bottom_navigation_setting
import myapplication.composeapp.generated.resources.discord_settings
import myapplication.composeapp.generated.resources.google_headset_off
import myapplication.composeapp.generated.resources.google_headset_on
import myapplication.composeapp.generated.resources.google_mic_off
import myapplication.composeapp.generated.resources.google_mic_on
import myapplication.composeapp.generated.resources.headphone_off
import myapplication.composeapp.generated.resources.headphone_on
import myapplication.composeapp.generated.resources.microphone_off
import myapplication.composeapp.generated.resources.microphone_on
import myapplication.composeapp.generated.resources.options
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun WideHomePageBarButtons(
    modifier: Modifier = Modifier
) {
    var toggleMicrophone by remember { mutableStateOf(true) }
    var toggleHeadphone by remember { mutableStateOf(true) }
    Row(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        RetryToggleIconButtonWithOptions(
            size = 80.dp,
            iconToggleOn = Res.drawable.google_mic_on,
            iconToggleOff = Res.drawable.google_mic_off,
            toggleLabelOn = Res.string.microphone_on,
            toggleLabelOff = Res.string.microphone_off,
            optionLabel = Res.string.options,
            toggleState = toggleMicrophone,
            onClickToggle = {
                toggleMicrophone = !toggleMicrophone
            },
            onClickOptions = {}
        )
        RetryToggleIconButtonWithOptions(
            size = 80.dp,
            iconToggleOn = Res.drawable.google_headset_on,
            iconToggleOff = Res.drawable.google_headset_off,
            toggleLabelOn = Res.string.headphone_on,
            toggleLabelOff = Res.string.headphone_off,
            optionLabel = Res.string.options,
            toggleState = toggleHeadphone,
            onClickToggle = {
                toggleHeadphone = !toggleHeadphone
            },
            onClickOptions = {}
        )
        IconButton(
            modifier = Modifier
                .pointerHoverIcon(PointerIcon.Hand),
            onClick = {},
            shape = MaterialTheme.shapes.small,
            content = {
                Icon(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(Res.drawable.discord_settings),
                    contentDescription = stringResource(Res.string.bottom_navigation_setting)
                )
            }
        )
    }
}