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
val Migration_4_5 = object : Migration(3, 4) {
    override fun migrate(connection: SQLiteConnection) {
        connection.execSQL("ALTER TABLE MessageEntity DROP COLUMN sentAt")
        connection.execSQL("ALTER TABLE MessageEntity ADD COLUMN `sentAt` TEXT NOT NULL")
    }
}
