package io.adik5050.discord_like.ui.app.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.shared.composables.WelcomeBackground
import io.adik5050.discord_like.ui.app.welcome.composables.WelcomeButtons
import io.adik5050.discord_like.ui.app.welcome.composables.WelcomeContent
import io.adik5050.discord_like.ui.theme.AppTheme

@Composable
fun WelcomePage(
    modifier: Modifier = Modifier,
    onClickToLogin: () -> Unit,
    onClickToRegister: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        WelcomeBackground()
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            WelcomeContent(
                modifier = Modifier.padding(start = 32.dp, end = 32.dp)
            )
            WelcomeButtons(
                modifier = Modifier.padding(start = 32.dp, end = 32.dp),
                onClickLogin = onClickToLogin,
                onClickRegister = onClickToRegister
            )
        }
    }
}

@Composable
@Preview
fun PreviewwWelcome() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            WelcomePage(
                onClickToLogin = {},
                onClickToRegister = {}
            )
        }
    }
}
@Composable
@Preview
fun PreviewDarkwWelcome() {
    AppTheme (
        darkTheme = true
    ){
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            WelcomePage(
                onClickToLogin = {},
                onClickToRegister = {}
            )
        }
    }
}