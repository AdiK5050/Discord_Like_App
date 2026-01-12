package io.adik5050.discord_like.storage

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: UserEntity)

}

@Dao
interface ChannelDao {
    @Insert
    suspend fun insertChannel(channel: ChannelEntity)
}

@Dao
interface MessageDao {
    @Insert
    suspend fun insertMessage(message: MessageEntity)
}

