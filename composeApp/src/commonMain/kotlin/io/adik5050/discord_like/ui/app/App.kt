package io.adik5050.discord_like.ui.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.ui.app.navigation.MainNavigation
import io.adik5050.discord_like.ui.theme.AppTheme

@Composable
fun App(
    appDatabase: AppDatabase
) {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            MainNavigation(
                appDatabase = appDatabase
            )
        }
    }
}