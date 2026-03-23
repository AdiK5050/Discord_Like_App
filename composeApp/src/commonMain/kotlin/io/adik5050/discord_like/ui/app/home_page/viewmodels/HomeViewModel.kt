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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as ChannelInfo

        if (channelId != other.channelId) return false
        if (userCreatedId != other.userCreatedId) return false
        if (channelName != other.channelName) return false
        if (!message.contentEquals(other.message)) return false
        if (messageType != other.messageType) return false
        if (sentAt != other.sentAt) return false

        return true
    }

    override fun hashCode(): Int {
        var result = channelId
        result = 31 * result + userCreatedId
        result = 31 * result + channelName.hashCode()
        result = 31 * result + (message?.contentHashCode() ?: 0)
        result = 31 * result + (messageType?.hashCode() ?: 0)
        result = 31 * result + (sentAt?.hashCode() ?: 0)
        return result
    }
}

class HomeViewModel(
    val appDatabase: AppDatabase,
    userSession: UserSession
): ViewModel() {

    val userId = userSession.getUserId()
    val channelDao = appDatabase.getChannelDao()

    val channelList = channelDao.getChannelInfoByMemberIdAsFlow(userId)
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