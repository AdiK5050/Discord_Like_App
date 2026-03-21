package io.adik5050.discord_like.platform_specific

import androidx.compose.ui.platform.ClipEntry
import androidx.compose.ui.platform.toClipEntry


actual fun String.toClipEntry(): ClipEntry = android.content.ClipData.newPlainText(this, this).toClipEntry()

actual suspend fun ClipEntry.getText(): String? {
    return tryGet {
        val itemCount = clipData.itemCount
        var textFull = ""
        for (i in 0 ..< itemCount) {
            val item = clipData.getItemAt(i)
            val text = item?.text
            if (text != null)
                textFull += text
        }
        textFull.ifEmpty { null }
    }
}
