package io.adik5050.discord_like.shared.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.ui.app.login.composables.WaveShape
import io.adik5050.discord_like.ui.theme.AppTheme

@Composable
fun WelcomeBackground() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
    ) {
        Box(
            modifier = Modifier
                .offset(y = 48.dp, x = (-15).dp)
                .size(80.dp)
                .rotate(45f)
                .clip(RectangleShape)
                .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
        )
        Box(
            modifier = Modifier
                .offset(y = 115.dp, x = 136.dp)
                .size(96.dp)
                .clip(CircleShape)
                .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
        )
        DottedPattern(
            modifier = Modifier
                .offset(y = 72.dp, x = 272.dp)
        )
        Box(
            modifier = Modifier
                .offset(y = 256.dp, x = 64.dp)
                .width(150.dp)
                .height(32.dp)
                .clip(RectangleShape)
                .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
        )
        Box(
            modifier = Modifier
                .offset(y = 60.dp,x = 275.dp)
                .size(height = 30.dp, width = 200.dp)
                .rotate(-95f)
                .clip(WaveShape())
                .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
        )
        Box(
            modifier = Modifier
                .offset(y = 350.dp, x = 335.dp)
                .size(100.dp)
                .rotate(90f)
                .clip(CircleShape)
                .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
        )
    }
}

@Composable
fun DottedPattern(
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        DottedRow()
        DottedRow()
        DottedRow()
    }
}

@Composable
fun DottedRow() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Box(
            modifier = Modifier
                .size(4.dp)
                .clip(CircleShape)
                .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
        )
        Box(
            modifier = Modifier
                .size(4.dp)
                .clip(CircleShape)
                .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
        )
        Box(
            modifier = Modifier
                .size(4.dp)
                .clip(CircleShape)
                .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
        )
        Box(
            modifier = Modifier
                .size(4.dp)
                .clip(CircleShape)
                .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
        )
        Box(
            modifier = Modifier
                .size(4.dp)
                .clip(CircleShape)
                .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
        )
        Box(
            modifier = Modifier
                .size(4.dp)
                .clip(CircleShape)
                .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
        )
        Box(
            modifier = Modifier
                .size(4.dp)
                .clip(CircleShape)
                .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
        )
        
    }

}
@Preview
@Composable
fun PreviewWelcomeBackground() {
    AppTheme (
        darkTheme = false
    ) {
        WelcomeBackground()
    }
}
@Preview
@Composable
fun PreviewDarkWelcomeBackground() {
    AppTheme (
        darkTheme = true
    ) {
        WelcomeBackground()
    }
}