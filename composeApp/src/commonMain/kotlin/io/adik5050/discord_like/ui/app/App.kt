package io.adik5050.discord_like.ui.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.ui.app.chat_page.ChatPage
import io.adik5050.discord_like.ui.app.navigation.Navigation
import io.adik5050.discord_like.ui.theme.AppTheme

@Composable
fun App(
    windowSize: WindowSizes = WindowSizes.COMPACT,
) {
    AppTheme {
        Surface (
            modifier = Modifier.fillMaxSize()
        ) {
            ChatPage(
                windowSize = windowSize,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}
