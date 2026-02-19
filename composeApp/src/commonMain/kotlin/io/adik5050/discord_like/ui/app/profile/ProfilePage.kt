package io.adik5050.discord_like.ui.app.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fitInside
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.WindowInsetsRulers
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.adik5050.discord_like.shared.composables.OnlineStatus
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.UserSession
import io.adik5050.discord_like.ui.app.profile.composables.ContentCards
import io.adik5050.discord_like.ui.app.profile.composables.ProfileInfo
import io.adik5050.discord_like.ui.app.profile.composables.ProfileTopOptions
import io.adik5050.discord_like.ui.app.profile.viewmodels.ProfileViewModel

@Composable
fun ProfilePage(
    modifier: Modifier= Modifier,
    appDatabase: AppDatabase,
    userSession: UserSession,
    onNavigateBack: () -> Unit,
    onNavigateToEditProfile: () -> Unit,
    onNavigateToWelcome: () -> Unit,
    profileViewModel: ProfileViewModel = viewModel { ProfileViewModel(appDatabase,userSession) }
) {
    LaunchedEffect(Unit) {
        profileViewModel.loadResources()
    }
    Surface (
        modifier = modifier
            .fitInside(WindowInsetsRulers.SafeDrawing.current)
            .fillMaxSize(),
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
                            onLogout = onNavigateToWelcome
                        )
                    }
                    item {
                        ProfileInfo(
                            displayName = profileViewModel.displayName,
                            username = profileViewModel.username,
                            pronouns = profileViewModel.pronouns,
                            image = profileViewModel.userProfileImage,
                            clickableImage = true,
                            onClickImage = {},
                            status = OnlineStatus.ONLINE,
                            onEdit = onNavigateToEditProfile,
                            thoughts = "What's new in Christmas?",
                            onClickNotes = {},
                        )
                    }
                    item {
                        ContentCards(
                            about = "Change Is Fated",
                            memberSince = "Jul 9, 2024"
                        )
                    }
                }
            }
        }
    )
}
