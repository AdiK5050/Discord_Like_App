package io.adik5050.discord_like.ui.app.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fitInside
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.WindowInsetsRulers
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wannaverse.imageselector.toImageBitmap
import com.wannaverse.imageselector.withAspectRatio
import io.adik5050.discord_like.shared.composables.ImageWithStatus
import io.adik5050.discord_like.shared.composables.OnlineStatus
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.UserSession
import io.adik5050.discord_like.ui.app.profile.composables.ProfileInfoImageRow
import io.adik5050.discord_like.ui.app.profile.composables.ProfileInfoTextRow
import io.adik5050.discord_like.ui.app.profile.viewmodels.EditProfileViewModel
import io.adik5050.discord_like.ui.app.profile.viewmodels.UserProfileUiState
import io.adik5050.discord_like.ui.theme.AppTheme
import kotlinx.coroutines.delay
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.about_me
import myapplication.composeapp.generated.resources.arrow_back_24dp_e3e3e3_fill0_wght400_grad0_opsz24
import myapplication.composeapp.generated.resources.display_name
import myapplication.composeapp.generated.resources.pronouns
import myapplication.composeapp.generated.resources.save
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun EditProfilePage(
    modifier: Modifier = Modifier,
    appDatabase: AppDatabase,
    userSession: UserSession,
    editProfileViewModel: EditProfileViewModel = viewModel { EditProfileViewModel(appDatabase, userSession) },
    onNavigateBack: () -> Unit
) {

    Surface(
        modifier = modifier
            .fitInside(WindowInsetsRulers.SafeDrawing.current)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            EditProfileTopOptions(
                onNavigateBack = onNavigateBack,
                onSave = {
                    editProfileViewModel.onSave()
                    onNavigateBack()
                }
            )
            editProfileViewModel.userProfileImage?.let {
                Box (
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                ) {
                    Image(
                        bitmap = it.toImageBitmap().withAspectRatio(1f),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }
//            ImageWithStatus(
//                modifier = Modifier.size(82.dp),
//                image = editProfileViewModel.userProfileImage,
//                status = OnlineStatus.ONLINE,
//                statusAlignment = Alignment.TopEnd,
//                clickable = true,
//                onClick = { editProfileViewModel.chooseImage() }
//            )
            EditProfileInfo(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                username = editProfileViewModel.username,
                displayName = editProfileViewModel.displayName.text,
                pronouns = editProfileViewModel.pronouns.text,
                image = null,
                clickableImage = true,
                onClickImage = { editProfileViewModel.chooseImage() },
                status = OnlineStatus.EDIT,
                thoughts = "What's new in Christmas?",
                onClickNotes = {},
            )
            EditProfileTextFieldCard(
                displayName = editProfileViewModel.displayName,
                pronouns = editProfileViewModel.pronouns,
                aboutMe = editProfileViewModel.about,
                onDisplayNameChanged = editProfileViewModel::updateDisplayName,
                onPronounsChanged = editProfileViewModel::updatePronouns,
                onAboutMeChanged = editProfileViewModel::updateAbout
            )
        }
    }
}

@Composable
fun EditProfileTopOptions(
    onNavigateBack: () -> Unit,
    onSave: () -> Unit
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
            content = {
                Icon(
                    painter = painterResource(Res.drawable.save),
                    contentDescription = "Save"
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
            displayName = displayName,
            username = username,
            pronouns = pronouns,
        )
    }
}

@Composable
fun EditProfileTextFieldCard(
    modifier: Modifier = Modifier,
    displayName: TextFieldValue,
    pronouns: TextFieldValue,
    aboutMe: TextFieldValue,
    onDisplayNameChanged: (newValue: TextFieldValue) ->  Unit,
    onPronounsChanged: (newValue: TextFieldValue) ->  Unit,
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
                onTextFieldValueChange = onDisplayNameChanged
            )
            EditProfileTextField(
                value = pronouns,
                label = Res.string.pronouns,
                onTextFieldValueChange = onPronounsChanged
            )
            EditProfileTextField(
                value = aboutMe,
                label = Res.string.about_me,
                onTextFieldValueChange = onAboutMeChanged
            )
        }
    }
}
@Composable
fun EditProfileTextField(
    modifier: Modifier = Modifier,
    value: TextFieldValue,
    label: StringResource,
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
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = { newValue ->
                onTextFieldValueChange(newValue)
            },
            shape = MaterialTheme.shapes.large,
            textStyle = MaterialTheme.typography.bodyMedium,
        )
    }
}
