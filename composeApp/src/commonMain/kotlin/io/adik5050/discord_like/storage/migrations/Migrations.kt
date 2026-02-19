package io.adik5050.discord_like.storage.migrations

import androidx.room.migration.Migration
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL

val Migration_1_2 = object: Migration(1,2) {
    override fun migrate(connection: SQLiteConnection) {
        connection.execSQL("ALTER TABLE MessageEntity ADD COLUMN sentAt INTEGER DEFAULT VALUE = CURRENT_TIMESTAMP NOT NULL")
    }
}

val Migration_2_3 = object: Migration(2, 3) {
    override fun migrate(connection: SQLiteConnection) {
        connection.execSQL("ALTER TABLE ChannelMembersEntity ADD COLUMN channelMembersId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL")
    }
}

val Migration_3_4 = object : Migration(3, 4) {
    override fun migrate(connection: SQLiteConnection) {
        connection.execSQL("ALTER TABLE MessageEntity DROP COLUMN message")
        connection.execSQL("ALTER TABLE MessageEntity DROP COLUMN sentAt")
        connection.execSQL("ALTER TABLE MessageEntity ADD COLUMN message BLOB NOT NULL")
        connection.execSQL("ALTER TABLE MessageEntity ADD COLUMN `sentAt` TEXT DEFAULT CURRENT_TIMESTAMP")
    }
}
val Migration_4_5 = object : Migration(4, 5) {
    override fun migrate(connection: SQLiteConnection) {
        connection.execSQL("ALTER TABLE MessageEntity DROP COLUMN sentAt")
        connection.execSQL("ALTER TABLE MessageEntity ADD COLUMN `sentAt` TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP")
    }
}
val Migration_5_6 = object : Migration(5, 6) {
    override fun migrate(connection: SQLiteConnection) {
        connection.execSQL("ALTER TABLE UserEntity ADD COLUMN 'displayName' TEXT")
        connection.execSQL("ALTER TABLE UserEntity ADD COLUMN `pronouns` TEXT")
        connection.execSQL("ALTER TABLE UserEntity ADD COLUMN `userThoughts` TEXT")
        connection.execSQL("ALTER TABLE UserEntity ADD COLUMN `onlineStatus` TEXT NOT NULL DEFAULT Offline")
        connection.execSQL("UPDATE UserEntity SET displayName = UserEntity.username")
    }
}
val Migration_6_7 = object : Migration(6, 7) {
    override fun migrate(connection: SQLiteConnection) {
        connection.execSQL("ALTER TABLE UserEntity ADD COLUMN 'about' TEXT")
        connection.execSQL("ALTER TABLE UserEntity ADD COLUMN 'deleted' INTEGER NOT NULL DEFAULT 0")
        connection.execSQL("ALTER TABLE UserEntity RENAME 'userThoughts' TO 'thoughts'")
        connection.execSQL("Create INDEX index_ChannelEntity_userCreatedId ON ChannelEntity (userCreatedId)")
        connection.execSQL("Create INDEX index_MessageEntity_channelId ON MessageEntity (channelId)")
        connection.execSQL("Create INDEX index_MessageEntity_senderId ON MessageEntity (senderId)")

        connection.execSQL("ALTER TABLE MessageEntity ADD COLUMN 'reactions' TEXT")
        connection.execSQL("ALTER TABLE ChannelMembersEntity RENAME TO temp")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `ChannelMembersEntity` (`channelMembersId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `channelId` INTEGER NOT NULL, `memberId` INTEGER NOT NULL, FOREIGN KEY(`channelId`) REFERENCES `ChannelEntity`(`channelId`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`memberId`) REFERENCES `UserEntity`(`userId`) ON UPDATE CASCADE ON DELETE CASCADE )")
        connection.execSQL("INSERT INTO ChannelMembersEntity SELECT * FROM Temp")
        connection.execSQL("DROP TABLE Temp")
        connection.execSQL("Create INDEX index_ChannelMembersEntity_channelId ON ChannelMembersEntity (channelId)")
        connection.execSQL("Create INDEX index_ChannelMembersEntity_memberId ON ChannelMembersEntity (memberId)")
    }
}

