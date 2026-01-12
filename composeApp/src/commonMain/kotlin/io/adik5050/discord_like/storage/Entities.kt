package io.adik5050.discord_like.storage

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)val userId: Int = 0,
    val username: String,
    val password: String,
    val profileImage: ByteArray? = ByteArray(0)
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as UserEntity

        if (userId != other.userId) return false
        if (username != other.username) return false
        if (password != other.password) return false
        if (!profileImage.contentEquals(other.profileImage)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = userId
        result = 31 * result + username.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + (profileImage?.contentHashCode() ?: 0)
        return result
    }
}

@Entity (
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = ["userId"],
        childColumns = ["userCreatedId"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )]
)
data class ChannelEntity(
    @PrimaryKey(autoGenerate = true) val channelId: Int = 0,
    val channelName: String,
    val userCreatedId: Int,
    val channelImage: ByteArray?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as ChannelEntity

        if (channelId != other.channelId) return false
        if (channelName != other.channelName) return false
        if (!channelImage.contentEquals(other.channelImage)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = channelId
        result = 31 * result + channelName.hashCode()
        result = 31 * result + (channelImage?.contentHashCode() ?: 0)
        return result
    }
}

@Entity (
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = ["userId"],
        childColumns = ["senderId"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    ),
        ForeignKey(
            entity = ChannelEntity::class,
            parentColumns = ["channelId"],
            childColumns = ["channelId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        )]
)

data class MessageEntity(
    @PrimaryKey(autoGenerate = true) val messageId: Int = 0,
    val message: Any,
    val senderId: Int,
    val channelId: Int,
    val messageType: MessageType,
    
)

@Entity(
    foreignKeys = [ForeignKey(
        entity = ChannelEntity::class,
        parentColumns = ["channelId"],
        childColumns = ["channelId"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )]
)
data class ChannelMembersEntity(
    val channelId: Int,
    val memberId: Int
)
