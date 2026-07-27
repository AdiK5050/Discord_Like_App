package io.adik5050.discord_like.platform_specific

import androidx.compose.ui.platform.ClipEntry

expect fun String.toClipEntry(): ClipEntry

expect suspend fun ClipEntry.getText(): String?

// Safe execution wrapper
inline fun <T> tryGet(data: () -> T): T? =
    try {
        data()
    } catch (_: Exception) {
        null
    }
