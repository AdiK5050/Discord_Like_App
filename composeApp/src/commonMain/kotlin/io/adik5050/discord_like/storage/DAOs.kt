package io.adik5050.discord_like.storage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.ABORT
import androidx.room.Query
import androidx.room.Transaction
import io.adik5050.discord_like.ui.app.chat.viewmodels.UserInfo
import io.adik5050.discord_like.ui.app.home_page.viewmodels.ChannelInfo
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

    @Query("SELECT * FROM ChannelEntity WHERE channelId = :channelId")
    suspend fun getChannelById(channelId: Int): ChannelEntity?

    @Query("SELECT CE.channelId, CE.channelName, CE.userCreatedId, ME.message, ME.messageType, ME.sentAt FROM ChannelEntity CE INNER JOIN ChannelMembersEntity CM  ON CM.channelId = CE.channelId LEFT JOIN MessageEntity ME ON ME.messageId = ( SELECT m2.messageId  FROM MessageEntity m2  WHERE m2.channelId = CE.channelId ORDER BY m2.sentAt DESC LIMIT 1 ) WHERE CM.memberId = :memberId ORDER BY ME.sentAt DESC;")
    fun getChannelInfo(memberId: Int): Flow<List<ChannelInfo>>

    @Query("SELECT channelImage FROM ChannelEntity WHERE channelId = :channelId")
    suspend fun getChannelImage(channelId: Int): ByteArray?
}

@Dao
interface MessageDao {
    @Query("INSERT INTO MessageEntity (message, senderId, channelId, repliedTo, messageType) VALUES (:message, :senderId, :channelId, :repliedTo, :messageType)")
    suspend fun insertMessage(senderId: Int, channelId: Int, repliedTo: Int?, messageType: MessageType, message: ByteArray)

    @Query("SELECT messageId, message, senderId, channelId, repliedTo, messageType, strftime('%I:%M',sentAt, 'localtime') as sentAt FROM MessageEntity WHERE channelID = :channelID")
    fun getAllMessagesByChannelID(channelID: Int): Flow<List<MessageEntity>>

    @Query("UPDATE MessageEntity SET message = :newMessage WHERE messageId = :messageId")
    suspend fun updateMessage(messageId: Int, newMessage: ByteArray)

    @Query("DELETE FROM MessageEntity WHERE messageId = :messageId")
    suspend fun deleteMessage(messageId: Int)
}
