package io.adik5050.discord_like.ui.app.profile

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.shared.composables.OnlineStatus
import io.adik5050.discord_like.ui.app.profile.composables.ContentCards
import io.adik5050.discord_like.ui.app.profile.composables.ProfileInfo
import io.adik5050.discord_like.ui.app.profile.composables.ProfileTopOptions
import io.adik5050.discord_like.ui.app.profile.viewmodels.ProfileViewModel
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.cancel_button
import myapplication.composeapp.generated.resources.confirm_button
import myapplication.composeapp.generated.resources.logout
import myapplication.composeapp.generated.resources.logout_account_alert_body
import myapplication.composeapp.generated.resources.logout_account_alert_title
import myapplication.composeapp.generated.resources.logout_icon
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ProfilePage(
    modifier: Modifier= Modifier,
    profileViewModel: ProfileViewModel,
    onNavigateBack: () -> Unit,
    onNavigateToEditProfile: () -> Unit,
    onNavigateToWelcome: () -> Unit
) {
    var showLogoutDialog by remember { mutableStateOf(false) }

    Surface (
        modifier = modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeContent.only(WindowInsetsSides.Bottom + WindowInsetsSides.Top)),
        content = {
            Column (
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            ){
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    item {
                        ProfileTopOptions(
                            onNavigateBack = onNavigateBack,
                            onLogout = {
                                showLogoutDialog = true
                            }
                        )
                    }
                    item {
                        ProfileInfo(
                            displayName = profileViewModel.displayName,
                            username = profileViewModel.username,
                            pronouns = profileViewModel.pronouns,
                            thoughts = profileViewModel.thoughts,
                            image = profileViewModel.userProfileImage,
                            clickableImage = true,
                            onClickImage = {},
                            status = OnlineStatus.ONLINE,
                            onEdit = onNavigateToEditProfile,
                        )
                    }
                    item {
                        ContentCards(
                            about = profileViewModel.about,
                            memberSince = "Jul 9, 2024"
                        )
                    }
                }
                AnimatedVisibility(showLogoutDialog) {
                    AlertDialog(
                        onDismissRequest = { showLogoutDialog = false },
                        shape = MaterialTheme.shapes.medium,
                        confirmButton = {
                            Button(
                                onClick = {
                                    showLogoutDialog = false
                                    onNavigateToWelcome()
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
                                onClick = { showLogoutDialog = false },
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
                                painter = painterResource(Res.drawable.logout),
                                contentDescription = stringResource(Res.string.logout_icon)
                            )
                        },
                        title = {
                            Text(
                                text = stringResource(Res.string.logout_account_alert_title),
                                style = MaterialTheme.typography.titleMedium
                            )
                        },
                        text = {
                            Text(
                                text = stringResource(Res.string.logout_account_alert_body),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    )
                }
            }
        }
    )
}
