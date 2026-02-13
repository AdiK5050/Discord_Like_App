package io.adik5050.discord_like.ui.app.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fitInside
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.WindowInsetsRulers
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.adik5050.discord_like.shared.composables.OnlineStatus
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.UserSession
import io.adik5050.discord_like.ui.app.profile.composables.ProfileInfoImageRow
import io.adik5050.discord_like.ui.app.profile.composables.ProfileInfoTextRow
import io.adik5050.discord_like.ui.app.profile.viewmodels.ProfileViewModel

@Composable
fun EditProfilePage(
    modifier: Modifier = Modifier,
    appDatabase: AppDatabase,
    userSession: UserSession,
    profileViewModel: ProfileViewModel = viewModel { ProfileViewModel(appDatabase, userSession) }
) {
    Surface(
        modifier = modifier
            .fitInside(WindowInsetsRulers.SafeDrawing.current)
            .fillMaxSize()
    ) {
        EditProfileInfo(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            name = profileViewModel.userName,
            userId = profileViewModel.userId.toString(),
            pronouns = "He/Him",
            image = profileViewModel.userProfileImage,
            clickableImage = true,
            onClickImage = {},
            status = OnlineStatus.EDIT,
            thoughts = "What's new in Christmas?",
            onClickNotes = {},
        )
    }
}

@Composable
fun EditProfileInfo (
    modifier: Modifier = Modifier,
    name: String,
    userId: String,
    pronouns: String,
    image: ByteArray?,
    clickableImage: Boolean,
    onClickImage: () -> Unit,
    status: OnlineStatus,
    thoughts: String? = null,
    onClickNotes: () -> Unit = {}
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
            onClickNotes = onClickNotes
        )
        ProfileInfoTextRow(
            modifier,
            name = name,
            userId = userId,
            pronouns = pronouns,
        )
    }
}