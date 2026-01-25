package io.adik5050.discord_like.ui.app.welcome.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.app_logo
import myapplication.composeapp.generated.resources.discord_logo
import myapplication.composeapp.generated.resources.welcome
import myapplication.composeapp.generated.resources.welcome_script
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun WelcomeContent(
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(Res.drawable.discord_logo),
            contentDescription = stringResource(Res.string.app_logo),
            modifier = Modifier.size(100.dp),
        )
        Text(
            text = stringResource(Res.string.welcome),
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 45.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
        )
        Text(
            text = stringResource(Res.string.welcome_script),
            style = MaterialTheme.typography.bodySmall,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            lineHeight = 25.sp,
        )
    }
}