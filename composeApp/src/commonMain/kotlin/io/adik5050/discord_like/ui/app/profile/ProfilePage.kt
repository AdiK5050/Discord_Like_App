package io.adik5050.discord_like.ui.app.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fitInside
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.WindowInsetsRulers
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wannaverse.imageselector.toImageBitmap
import io.adik5050.discord_like.shared.composables.OnlineStatus
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.UserSession
import io.adik5050.discord_like.ui.app.profile.composables.ContentCards
import io.adik5050.discord_like.ui.app.profile.composables.ProfileInfo
import io.adik5050.discord_like.ui.app.profile.composables.TopOptions
import io.adik5050.discord_like.ui.app.profile.viewmodels.ProfileViewModel

@Composable
fun ProfilePage(
    modifier: Modifier= Modifier,
    appDatabase: AppDatabase,
    userSession: UserSession,
    onNavigateBack: () -> Unit,
    onNavigateToEditProfile: () -> Unit,
    profileViewModel: ProfileViewModel = viewModel { ProfileViewModel(appDatabase, userSession) }
) {
    val image = remember { profileViewModel.image }
    val bitmap = image.value?.bytes?.toImageBitmap()
    Surface (
        modifier = modifier
            .fitInside(WindowInsetsRulers.SafeDrawing.current)
            .fillMaxSize(),
        content = {
            Column (
                modifier = Modifier
            ) {
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    item {
                        TopOptions(
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                            onNavigateBack = onNavigateBack,
                            onNavigateToSettings = {}
                        )
                    }
                    item {
                        ProfileInfo(
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                            name = profileViewModel.userName,
                            userId = profileViewModel.userId.toString(),
                            pronouns = "He/Him",
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
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                            about = "Change Is Fated",
                            memberSince = "Jul 9, 2024"
                        )
                    }
                }
            }
        }
    )
}
