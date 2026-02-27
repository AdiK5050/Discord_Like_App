package io.adik5050.discord_like.ui.app.home_page.viewmodels

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wannaverse.imageselector.toImageBitmap
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.MessageType
import io.adik5050.discord_like.storage.UserSession
import io.adik5050.discord_like.ui.app.create_channel.viewmodels.EntityImage
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@Stable
data class ChannelInfo(
    val channelId: Int,
    val channelName: String,
    val userCreatedId: Int,
    val message: ByteArray?,
    val messageType: MessageType?,
    val sentAt: String?
)
class HomeViewModel(
    val appDatabase: AppDatabase,
    userSession: UserSession
): ViewModel() {

    val userId = userSession.getUserId()
    val channelDao = appDatabase.getChannelDao()

    val channelList = channelDao.getChannelInfo(userId)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    val channelImageList: SnapshotStateList<EntityImage> = mutableStateListOf()

    fun loadChannelImages(channelList: List<ChannelInfo>) = viewModelScope.launch {
        channelList.forEach { channelInfo ->
            channelDao.getChannelImage(channelInfo.channelId)?.let {
                channelImageList.add(EntityImage(channelInfo.channelId,it.toImageBitmap()))
            }
        }
    }
}