package io.adik5050.discord_like.storage

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import io.adik5050.discord_like.storage.migrations.Migration_1_2
import io.adik5050.discord_like.storage.migrations.Migration_2_3
import io.adik5050.discord_like.storage.migrations.Migration_3_4
import io.adik5050.discord_like.storage.migrations.Migration_4_5
import io.adik5050.discord_like.storage.migrations.Migration_5_6
import io.adik5050.discord_like.storage.migrations.Migration_6_7
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

fun getDatabase(): AppDatabase {
    val dbFilePath = documentDirectory() + "/my_room.db"
    return Room.databaseBuilder<AppDatabase>(
        name = dbFilePath,
    ).setQueryCoroutineContext(Dispatchers.IO)
        .addMigrations(Migration_1_2, Migration_2_3, Migration_3_4, Migration_4_5, Migration_5_6, Migration_6_7)
        .setDriver(BundledSQLiteDriver())
        .build()
}

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}