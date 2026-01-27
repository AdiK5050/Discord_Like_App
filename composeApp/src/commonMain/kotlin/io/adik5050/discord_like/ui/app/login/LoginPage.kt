package io.adik5050.discord_like.ui.app.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.adik5050.discord_like.shared.composables.LoginOrRegisterHeaderText
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.shared.composables.WelcomeBackground
import io.adik5050.discord_like.ui.app.login.composables.LoginButtons
import io.adik5050.discord_like.ui.app.login.composables.LoginTextField
import io.adik5050.discord_like.ui.app.login.viewmodels.LoginViewModel
import io.adik5050.discord_like.ui.theme.AppTheme
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.login_email_text_field
import myapplication.composeapp.generated.resources.login_heading
import myapplication.composeapp.generated.resources.password_text_field
import org.jetbrains.compose.resources.stringResource

@Suppress("ParamsComparedByRef")
@Composable
fun LoginPage(
    modifier: Modifier = Modifier,
    appDatabase: AppDatabase,
    loginViewModel: LoginViewModel = viewModel { LoginViewModel(appDatabase) },
    onNavigateToMainPage: () -> Unit,
    onNavigateToWelcomePage: () -> Unit
) {
    //Use only once to fill fake data in the database.
//    LaunchedEffect(Unit) {
//        loginViewModel.fillDataInDatabase()
//    }
    if(loginViewModel.loginSuccessful.value) onNavigateToMainPage()
    WelcomeBackground()
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        LoginOrRegisterHeaderText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            heading = stringResource(Res.string.login_heading),
            onClickBack = onNavigateToWelcomePage
        )
        LoginTextField(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            label = Res.string.login_email_text_field,
            textFieldValue = loginViewModel.usernameTextFieldValue.value,
            onTextFieldValueChange = { newValue ->
                loginViewModel.resetErrorStatus()
                loginViewModel.updateUsername(newValue)
                loginViewModel.enableButton()
            },
            visualTransformation = false,
        )
        LoginTextField(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            label = Res.string.password_text_field,
            textFieldValue = loginViewModel.passwordTextFieldValue.value,
            onTextFieldValueChange = { newValue ->
                loginViewModel.resetErrorStatus()
                loginViewModel.updatePassword(newValue)
                loginViewModel.enableButton()
            },
            visualTransformation = true
        )
        LoginButtons(
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
            enabled = loginViewModel.loginButtonEnabled.value,
            onClickLogin = {
                loginViewModel.login()
            }
        )
        LoginError(
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
            loginViewModel.isError.value,
            loginViewModel.errorMessage.value,
        )
    }
}

@Composable
fun LoginError(
    modifier: Modifier = Modifier,
    isError: Boolean,
    errorMessage: String
) {
    AnimatedVisibility( visible = isError) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .border(color = MaterialTheme.colorScheme.errorContainer, width = 1.dp, shape = MaterialTheme.shapes.medium),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = errorMessage,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.error,
            )
        }
    }
}

@Preview
@Composable
fun PreviewLoginPage() {
    AppTheme(
        darkTheme = false
    ) {
        Surface {
//            LoginPage(
//                modifier = Modifier
//                    .fillMaxSize()
//            )
        }
    }
}
@Preview
@Composable
fun DarkPreviewLoginPage() {
    AppTheme(
        darkTheme = true
    ) {
        Surface {
//            LoginPage(
//                modifier = Modifier
//                    .fillMaxSize()
//
//            )
        }
    }
}
