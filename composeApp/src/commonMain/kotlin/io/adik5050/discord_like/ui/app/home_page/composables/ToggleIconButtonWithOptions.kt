package io.adik5050.discord_like.ui.app.home_page.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.VerticalDivider
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.ui.theme.AppTheme
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.direct_down
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ToggleIconButtonWithOptions(
    modifier: Modifier = Modifier,
    iconToggleOn: DrawableResource,
    iconToggleOff: DrawableResource,
    toggleLabelOn: StringResource,
    toggleLabelOff: StringResource,
    toggleState: Boolean
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered: Boolean by interactionSource.collectIsHoveredAsState()

    Row(
        modifier = modifier
            .clip(shape = MaterialTheme.shapes.medium)
            .hoverable(interactionSource)
            .background(color = if(isHovered) MaterialTheme.colorScheme.surfaceContainerLow else MaterialTheme.colorScheme.surfaceContainer),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        AnimatedVisibility(toggleState) {
            IconButton(
                onClick = {},
                shape = MaterialTheme.shapes.small
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(iconToggleOn),
                    contentDescription = stringResource(toggleLabelOn)
                )
            }
        }
        AnimatedVisibility(!toggleState) {
            IconButton(
                shape = MaterialTheme.shapes.small,
                onClick = {},
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(iconToggleOff),
                    contentDescription = stringResource(toggleLabelOff)
                )
            }
        }
        IconButton(
            shape = MaterialTheme.shapes.small,
            onClick = {},
            content = {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(Res.drawable.direct_down),
                    contentDescription = "Options"
                )
            }
        )
    }
}

@Composable
fun RetryToggleIconButtonWithOptions(
    modifier: Modifier = Modifier,
    size: Dp,
    iconToggleOn: DrawableResource,
    iconToggleOff: DrawableResource,
    toggleLabelOn: StringResource,
    toggleLabelOff: StringResource,
    optionLabel: StringResource,
    toggleState: Boolean,
    onClickToggle: () -> Unit,
    onClickOptions: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered: Boolean by interactionSource.collectIsHoveredAsState()
    val height by remember { mutableStateOf(size/2) }
    val width by remember { mutableStateOf(size) }
    var containerAlpha by remember { mutableStateOf(1f) }

    if(isHovered) containerAlpha = 0.5f else 1f
    Box(
        modifier = modifier
            .height(height)
            .width(width)
            .clip(MaterialTheme.shapes.small)
            .hoverable(interactionSource)
            .background(color =
                if(!toggleState) MaterialTheme.colorScheme.errorContainer.copy(alpha = containerAlpha)
                else MaterialTheme.colorScheme.surfaceContainer.copy(alpha = containerAlpha)),
    ) {
        Row(
            modifier = Modifier
                .matchParentSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AnimatedVisibility(toggleState) {
                Box(
                    modifier = Modifier
                        .weight(7f)
                        .height(height)
                        .clickable(
                            onClick = onClickToggle
                        )
                        .pointerHoverIcon(PointerIcon.Hand),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(size/2),
                        painter = painterResource(iconToggleOn),
                        contentDescription = stringResource(toggleLabelOn)
                    )
                }
            }
            AnimatedVisibility(!toggleState) {
                Box(
                    modifier = Modifier
                        .weight(7f)
                        .height(height)
                        .clickable(
                            onClick = onClickToggle
                        )
                        .pointerHoverIcon(PointerIcon.Hand),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(size/2),
                        painter = painterResource(iconToggleOff),
                        contentDescription = stringResource(toggleLabelOff)
                    )
                }
            }

            VerticalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.surfaceContainer)
            Box(
                modifier = Modifier
                    .weight(3f)
                    .height(height)
                    .clickable(
                        onClick = { onClickOptions }
                    )
                    .pointerHoverIcon(PointerIcon.Hand),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .size(size/3),
                    painter = painterResource(Res.drawable.direct_down),
                    contentDescription = stringResource(optionLabel)
                )
            }
        }
    }
}
@Preview
@Composable
fun PreviewToggleIconButtonWithOptions() {
    AppTheme(
        darkTheme = true
    ) {
        Surface(
            color = MaterialTheme.colorScheme.surface
        ) {
        }
    }
}
