package io.adik5050.discord_like.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.ABORT
import androidx.room.Query
import androidx.room.Transaction
import io.adik5050.discord_like.ui.app.chat.viewmodels.UserInfo
import io.adik5050.discord_like.ui.app.profile.viewmodels.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("INSERT INTO UserEntity (username, password, displayName, onlineStatus, profileImage) VALUES(:username, :password,:username, :onlineStatus, :profileImage)" )
    suspend fun insertUser(username: String, password: String, onlineStatus: String, profileImage: ByteArray?)

    @Query("SELECT * FROM UserEntity WHERE username = :username")
    suspend fun getUserWithName(username: String): UserEntity?

    @Query("SELECT UserEntity.userId, UserEntity.username, UserEntity.displayName, UserEntity.onlineStatus FROM UserEntity")
    suspend fun getAllUsers(): List<UserInfo>
    @Query("SELECT UserEntity.userId, UserEntity.username, UserEntity.displayName, UserEntity.onlineStatus FROM UserEntity INNER JOIN main.ChannelEntity CE on UserEntity.userId = CE.userCreatedId WHERE CE.channelId = :channelId")
    fun getUserWithChannelId(channelId: Int): Flow<List<UserInfo>>

    @Query("SELECT UserEntity.userId, UserEntity.username, UserEntity.displayName, UserEntity.pronouns, UserEntity.thoughts, UserEntity.about, UserEntity.onlineStatus FROM UserEntity WHERE userId = :userId")
    suspend fun getUserWithUserId(userId: Int): User?

    @Query("SELECT UserEntity.profileImage FROM UserEntity WHERE userId = :userId")
    suspend fun getUserProfilePic(userId: Int): ByteArray?

    @Query("UPDATE UserEntity SET displayName = :displayName, pronouns = :pronouns, thoughts = :thoughts, about = :about, profileImage = :profileImage WHERE userId = :userId")
    suspend fun setUserProfileInfo(userId: Int, displayName: String, pronouns: String, thoughts: String?, about: String?, profileImage: ByteArray?)
}

@Dao
interface ChannelDao {

    @Insert(onConflict = ABORT)
    suspend fun insertChannel(channelEntity: ChannelEntity): Long

    @Query("INSERT INTO ChannelMembersEntity (channelId, memberId) VALUES (:channelId, :memberId)")
    suspend fun insertChannelMember(channelId: Int, memberId: Int)

    @Query("SELECT channelId FROM CHANNELENTITY WHERE rowId = :rowId")
    suspend fun getChannelIdByRowId(rowId: Long): Int

    @Transaction
    suspend fun insertAndGetChannelId(channelEntity: ChannelEntity): Int {
        val rowId = insertChannel(channelEntity)
        val channelId = getChannelIdByRowId(rowId)
        return channelId
    }

}

@Dao
interface MessageDao {
    @Query("INSERT INTO MessageEntity (message, senderId, channelId, repliedTo, messageType) VALUES (:message, :senderId, :channelId, :repliedTo, :messageType)")
    suspend fun insertMessage(senderId: Int, channelId: Int, repliedTo: Int?, messageType: MessageType, message: ByteArray)

    @Query("SELECT messageId, message, senderId, channelId, repliedTo, messageType, strftime('%I:%M',sentAt, 'localtime') as sentAt FROM MessageEntity WHERE channelID = :channelID")
    fun getAllMessagesByChannelID(channelID: Int): Flow<List<MessageEntity>>
}
