package io.adik5050.discord_like.storage

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import io.adik5050.discord_like.storage.migrations.Migration_1_2
import io.adik5050.discord_like.storage.migrations.Migration_2_3
import io.adik5050.discord_like.storage.migrations.Migration_3_4
import io.adik5050.discord_like.storage.migrations.Migration_4_5
import kotlinx.coroutines.Dispatchers

fun getDatabase(context: Context): AppDatabase {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("my_room.db")
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    ).setQueryCoroutineContext(Dispatchers.IO)
        .setDriver(BundledSQLiteDriver())
        .addMigrations(Migration_1_2, Migration_2_3, Migration_3_4, Migration_4_5)
        .build()
}