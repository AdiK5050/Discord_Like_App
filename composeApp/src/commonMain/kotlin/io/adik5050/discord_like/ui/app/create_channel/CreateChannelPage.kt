package io.adik5050.discord_like.ui.app.create_channel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.UserSession
import io.adik5050.discord_like.ui.app.create_channel.composables.CreateChannelHeader
import io.adik5050.discord_like.ui.app.create_channel.composables.CreateChannelOptionsCard
import io.adik5050.discord_like.ui.app.create_channel.composables.CreateChannelUserCardList
import io.adik5050.discord_like.ui.app.create_channel.viewmodels.CreateChannelUiStates
import io.adik5050.discord_like.ui.app.create_channel.viewmodels.CreateChannelViewModel

@Composable
fun CreateChannelPage(
    modifier: Modifier = Modifier,
    appDatabase: AppDatabase,
    userSession: UserSession,
    createChannelViewModel: CreateChannelViewModel = viewModel { CreateChannelViewModel(appDatabase, userSession) },
    onNavigateToChannel: (channelId: Int) -> Unit,
    onNavigateBack: () -> Unit,
    onNavigateToError: (String) -> Unit
) {
    (createChannelViewModel.uiStates as? CreateChannelUiStates.ChannelCreated)?.let {
        onNavigateToChannel(it.channelId)
    }
    if(createChannelViewModel.error.trim().isNotEmpty()) {
        onNavigateToError(createChannelViewModel.error)
    }
    if (createChannelViewModel.uiStates == CreateChannelUiStates.Loading) {
        Dialog(
            onDismissRequest = {}
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(Modifier.size(40.dp))
            }
        }
    }
    else if (createChannelViewModel.uiStates == CreateChannelUiStates.Loaded) {
        Column(
            modifier = modifier
                .windowInsetsPadding(WindowInsets.safeContent.only(WindowInsetsSides.Bottom + WindowInsetsSides.Top))
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val alphabetsPresent = createChannelViewModel.userInfoList
                .groupBy { it.displayName.uppercase().first() }
                .keys
                .sorted()
            CreateChannelHeader(
                modifier = Modifier.padding(8.dp),
                onClickBack = onNavigateBack,
                onClickCreate = {
                    createChannelViewModel.createChannel()
                },
                enableCreateButton = createChannelViewModel.enableButton
            )
            LazyColumn(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    CreateChannelOptionsCard(
                        onClickNewChannel = {},
                        onClickAddFriend = {}
                    )
                }
                items(alphabetsPresent) { alphabet ->
                    createChannelViewModel.userInfoList
                        .groupBy { it.displayName.uppercase().first() }
                        .getOrElse(alphabet, defaultValue = { emptyList() })
                        .filter { it.userId != createChannelViewModel.userId }
                        .let { userInfoList ->
                            if (userInfoList.isNotEmpty()) {
                                Column {
                                    Text(
                                        modifier = Modifier.padding(8.dp),
                                        text = alphabet.toString(),
                                        style = MaterialTheme.typography.labelMedium,
                                        fontWeight = FontWeight.Bold
                                    )
                                    CreateChannelUserCardList(
                                        userInfoList = userInfoList,
                                        entityImageList = createChannelViewModel.userProfileImages,
                                        onClickCard = { memberId, selected ->
                                            createChannelViewModel.updateChannelMembersList(
                                                memberId = memberId,
                                                selected = selected
                                            )
                                        }
                                    )
                                }
                            }
                        }
                }
            }
        }
    }
}

