package io.adik5050.discord_like.storage

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor

@Database(entities = [
    UserEntity::class,
    ChannelEntity::class,
    MessageEntity::class,
    ChannelMembersEntity::class
                     ], version = 1)
@ConstructedBy (AppDatabaseConstructor::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getUserDao(): UserDao
    abstract fun getChannelDao(): ChannelDao
    abstract fun getMessageDao(): MessageDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("KotlinNoActualForExpect", "EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}