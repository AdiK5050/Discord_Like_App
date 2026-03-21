package io.adik5050.discord_like.platform_specific

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.ClipEntry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.Transferable

@OptIn(ExperimentalComposeUiApi::class)
actual fun String.toClipEntry() = ClipEntry(java.awt.datatransfer.StringSelection(this))

@OptIn(ExperimentalComposeUiApi::class)
actual suspend fun ClipEntry.getText(): String? = withContext(Dispatchers.IO) {
    tryGet {
        val transferable = nativeClipEntry as? Transferable
        if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor))
            transferable.getTransferData(DataFlavor.stringFlavor) as? String
        else null
    }
}