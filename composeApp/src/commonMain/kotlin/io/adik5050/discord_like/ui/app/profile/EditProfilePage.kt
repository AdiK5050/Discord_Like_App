package io.adik5050.discord_like.ui.app.profile

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigationevent.NavigationEventInfo
import androidx.navigationevent.compose.NavigationBackHandler
import androidx.navigationevent.compose.rememberNavigationEventState
import io.adik5050.discord_like.shared.composables.OnlineStatus
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.UserSession
import io.adik5050.discord_like.ui.app.profile.composables.ProfileInfoImageRow
import io.adik5050.discord_like.ui.app.profile.composables.ProfileInfoTextRow
import io.adik5050.discord_like.ui.app.profile.viewmodels.ProfileViewModel
import kotlinx.coroutines.launch
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.about_me
import myapplication.composeapp.generated.resources.arrow_back_24dp_e3e3e3_fill0_wght400_grad0_opsz24
import myapplication.composeapp.generated.resources.cancel_button
import myapplication.composeapp.generated.resources.confirm_button
import myapplication.composeapp.generated.resources.delete
import myapplication.composeapp.generated.resources.delete_icon
import myapplication.composeapp.generated.resources.discard_profile_alert_body
import myapplication.composeapp.generated.resources.discard_profile_alert_title
import myapplication.composeapp.generated.resources.display_name
import myapplication.composeapp.generated.resources.keep_editing_button
import myapplication.composeapp.generated.resources.pronouns
import myapplication.composeapp.generated.resources.save
import myapplication.composeapp.generated.resources.save_icon
import myapplication.composeapp.generated.resources.save_profile_alert_body
import myapplication.composeapp.generated.resources.save_profile_alert_title
import myapplication.composeapp.generated.resources.user_thoughts
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun EditProfilePage(
    modifier: Modifier = Modifier,
    appDatabase: AppDatabase,
    userSession: UserSession,
    profileViewModel: ProfileViewModel= viewModel { ProfileViewModel(appDatabase, userSession) },
    onNavigateBack: () -> Unit
) {
    var showSaveDialog by remember { mutableStateOf(false) }
    var discardChangesDialog by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    val keyboardHeight = WindowInsets.ime.getBottom(LocalDensity.current)

    val navigationEvenState = rememberNavigationEventState<NavigationEventInfo>(
        currentInfo = NavigationEventInfo.None,
    )

    NavigationBackHandler(
        state = navigationEvenState,
        isBackEnabled = true,
        onBackCancelled = { discardChangesDialog = false },
        onBackCompleted = {
            profileViewModel.hasChanges()
            if(profileViewModel.isInfoChanged) discardChangesDialog = true else onNavigateBack()
        }
    )
    LaunchedEffect(key1 = keyboardHeight) {
        coroutineScope.launch {
            scrollState.scrollBy(keyboardHeight.toFloat())
        }
    }
    LaunchedEffect(Unit) {
        profileViewModel.loadResources()
    }
    Surface(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .windowInsetsPadding(WindowInsets.safeContent.only(WindowInsetsSides.Bottom + WindowInsetsSides.Top))
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            EditProfileTopOptions(
                onNavigateBack = {
                    profileViewModel.hasChanges()
                    if(profileViewModel.isInfoChanged) discardChangesDialog = true else onNavigateBack()
                },
                onSave = { showSaveDialog = true },
                showSave = profileViewModel.isInfoChanged
            )
            EditProfileInfo(
                username = profileViewModel.username,
                displayName = profileViewModel.newDisplayName.text,
                pronouns = profileViewModel.newPronouns.text,
                thoughts = profileViewModel.newThoughts.text,
                image = profileViewModel.newUserProfileImage,
                clickableImage = true,
                onClickImage = { profileViewModel.chooseImage() },
                status = OnlineStatus.EDIT,
            )
            EditProfileTextFieldCard(
                modifier = Modifier
                    .padding(bottom = 16.dp),
                username = profileViewModel.username,
                displayName = profileViewModel.newDisplayName,
                pronouns = profileViewModel.newPronouns,
                thoughts = profileViewModel.newThoughts,
                aboutMe = profileViewModel.newAbout,
                onDisplayNameChanged = profileViewModel::updateDisplayName,
                onPronounsChanged = profileViewModel::updatePronouns,
                onThoughtsChanged = profileViewModel::updateThoughts,
                onAboutMeChanged = profileViewModel::updateAbout
            )
            AnimatedVisibility(showSaveDialog) {
                AlertDialog(
                    onDismissRequest = { showSaveDialog = false },
                    shape = MaterialTheme.shapes.medium,
                    confirmButton = {
                        Button(
                            onClick = {
                                discardChangesDialog = false
                                profileViewModel.onSave()
                                onNavigateBack()
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = MaterialTheme.colorScheme.primary,
                                disabledContainerColor = Color.Transparent,
                                disabledContentColor = MaterialTheme.colorScheme.primary
                            )
                        ) {
                            Text(
                                text = stringResource(Res.string.confirm_button),
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = { showSaveDialog = false },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = MaterialTheme.colorScheme.error,
                                disabledContainerColor = Color.Transparent,
                                disabledContentColor = MaterialTheme.colorScheme.error
                            )
                        ) {
                            Text(
                                text = stringResource(Res.string.cancel_button),
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(Res.drawable.save),
                            contentDescription = stringResource(Res.string.save_icon)
                        )
                    },
                    title = {
                        Text(
                            text = stringResource(Res.string.save_profile_alert_title),
                            style = MaterialTheme.typography.titleMedium
                        )
                    },
                    text = {
                        Text(
                            text = stringResource(Res.string.save_profile_alert_body),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                )
            }
            AnimatedVisibility(discardChangesDialog) {
                AlertDialog(
                    onDismissRequest = { discardChangesDialog = false },
                    shape = MaterialTheme.shapes.medium,
                    confirmButton = {
                        Button(
                            onClick = {
                                discardChangesDialog = false
                                onNavigateBack()
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = MaterialTheme.colorScheme.error,
                                disabledContainerColor = Color.Transparent,
                                disabledContentColor = MaterialTheme.colorScheme.error
                            )
                        ) {
                            Text(
                                text = stringResource(Res.string.confirm_button),
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = { discardChangesDialog = false },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = MaterialTheme.colorScheme.primary,
                                disabledContainerColor = Color.Transparent,
                                disabledContentColor = MaterialTheme.colorScheme.primary
                            )
                        ) {
                            Text(
                                text = stringResource(Res.string.keep_editing_button),
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(Res.drawable.delete),
                            contentDescription = stringResource(Res.string.delete_icon)
                        )
                    },
                    title = {
                        Text(
                            text = stringResource(Res.string.discard_profile_alert_title),
                            style = MaterialTheme.typography.titleMedium
                        )
                    },
                    text = {
                        Text(
                            text = stringResource(Res.string.discard_profile_alert_body),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun EditProfileTopOptions(
    onNavigateBack: () -> Unit,
    onSave: () -> Unit,
    showSave: Boolean,
) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = onNavigateBack,
            content = {
                Icon(
                    painter = painterResource(Res.drawable.arrow_back_24dp_e3e3e3_fill0_wght400_grad0_opsz24),
                    contentDescription = "Back"
                )
            }
        )
        IconButton(
            onClick = onSave,
            enabled = showSave,
            content = {
                Icon(
                    painter = painterResource(Res.drawable.save),
                    contentDescription = stringResource(Res.string.save_icon)
                )
            }
        )
    }
}
@Composable
fun EditProfileInfo (
    modifier: Modifier = Modifier,
    username: String,
    displayName: String,
    pronouns: String?,
    image: ImageBitmap?,
    clickableImage: Boolean,
    onClickImage: () -> Unit,
    status: OnlineStatus,
    thoughts: String? = null,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        ProfileInfoImageRow(
            modifier,
            image = image,
            status = status,
            statusAlignment = Alignment.TopEnd,
            thoughts = thoughts,
            clickableImage = clickableImage,
            onClickImage = onClickImage,
        )
        ProfileInfoTextRow(
            modifier,
            displayName = displayName,
            username = username,
            pronouns = pronouns,
        )
    }
}

@Composable
fun EditProfileTextFieldCard(
    modifier: Modifier = Modifier,
    username: String,
    displayName: TextFieldValue,
    pronouns: TextFieldValue,
    thoughts: TextFieldValue,
    aboutMe: TextFieldValue,
    onDisplayNameChanged: (newValue: TextFieldValue) ->  Unit,
    onPronounsChanged: (newValue: TextFieldValue) ->  Unit,
    onThoughtsChanged: (newValue: TextFieldValue) -> Unit,
    onAboutMeChanged: (newValue: TextFieldValue) ->  Unit,
) {
    Card(
        modifier = Modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    ) {
        Column (
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EditProfileTextField(
                value = displayName,
                label = Res.string.display_name,
                placeholder = username,
                onTextFieldValueChange = onDisplayNameChanged,
            )
            EditProfileTextField(
                value = pronouns,
                label = Res.string.pronouns,
                placeholder = "He/him/She/her",
                onTextFieldValueChange = onPronounsChanged,
            )
            EditProfileTextField(
                value = thoughts,
                label = Res.string.user_thoughts,
                placeholder = "How was your day?",
                onTextFieldValueChange = onThoughtsChanged,
            )
            EditProfileTextField(
                value = aboutMe,
                label = Res.string.about_me,
                placeholder = "Tell us about you",
                onTextFieldValueChange = onAboutMeChanged,
            )
        }
    }
}
@Composable
fun EditProfileTextField(
    modifier: Modifier = Modifier,
    value: TextFieldValue,
    label: StringResource,
    placeholder: String?,
    onTextFieldValueChange: (newValue: TextFieldValue) -> Unit,
) {
    Column (
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource( label),
            style = MaterialTheme.typography.titleSmall
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value,
            placeholder = {
                placeholder?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.alpha(0.5f)
                    )
                }
            },
            onValueChange = { newValue ->
                onTextFieldValueChange(newValue)
            },
            maxLines = 1,
            shape = MaterialTheme.shapes.large,
            textStyle = MaterialTheme.typography.bodyMedium,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            )
        )
    }
}
