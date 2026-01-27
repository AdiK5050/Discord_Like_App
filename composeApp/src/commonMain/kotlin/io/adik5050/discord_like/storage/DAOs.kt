package io.adik5050.discord_like.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.adik5050.discord_like.ui.app.chat.viewmodels.UserInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("INSERT INTO UserEntity (username, password, profileImage) VALUES(:username, :password, :profileImage)" )
    suspend fun insertUser(username: String, password: String, profileImage: ByteArray?)

    @Query("SELECT * FROM UserEntity WHERE username = :username")
    suspend fun getUserWithName(username: String): UserEntity?
    @Query("SELECT * FROM UserEntity")
    fun getAllUsersAsFlow(): Flow<List<UserEntity>>

    @Query("SELECT UserEntity.userId, UserEntity.username, UserEntity.profileImage FROM UserEntity INNER JOIN main.ChannelEntity CE on UserEntity.userId = CE.userCreatedId WHERE CE.channelId = :channelId")
    fun getUserWithChannelId(channelId: Int): Flow<List<UserInfo>>
}

@Dao
interface ChannelDao {
    @Insert
    suspend fun insertChannel(channel: ChannelEntity)

}

@Dao
interface MessageDao {
    @Query("INSERT INTO MessageEntity (message, senderId, channelId, repliedTo, messageType) VALUES (:message, :senderId, :channelId, :repliedTo, :messageType)")
    suspend fun insertMessage(senderId: Int, channelId: Int, repliedTo: Int?, messageType: MessageType, message: ByteArray)

    @Query("SELECT messageId, message, senderId, channelId, repliedTo, messageType, strftime('%I:%M',sentAt, 'localtime') as sentAt FROM MessageEntity WHERE channelID = :channelID")
    fun getAllMessagesByChannelID(channelID: Int): Flow<List<MessageEntity>>
}
