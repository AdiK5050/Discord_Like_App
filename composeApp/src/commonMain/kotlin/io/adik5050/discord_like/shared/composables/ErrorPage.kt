package io.adik5050.discord_like.shared.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import io.adik5050.discord_like.ui.theme.AppTheme

@Composable
fun ErrorPage(
    modifier: Modifier = Modifier,
    errorMessage: String,
    onGoBackToLastDestination: () -> Unit
) {
    Surface(
        contentColor = MaterialTheme.colorScheme.onErrorContainer
    ) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(0.8f),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "An Error Occurred",
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = errorMessage,
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center,
                )
                Button(
                    onClick = onGoBackToLastDestination,
                    content = {
                        Text("Go Back To Last Destination")
                    }
                )
            }
        }
    }
}

@Composable
@Preview
fun ErrorPagePreview() {
    AppTheme {
        ErrorPage(
            errorMessage = "Couldn't load the data.",
            onGoBackToLastDestination = {}
        )
    }
}
@Composable
@Preview
fun ErrorPageDarkPreview() {
    AppTheme(darkTheme = true) {
        ErrorPage(
            errorMessage = "Couldn't load the data.",
            onGoBackToLastDestination = {}
        )
    }
}