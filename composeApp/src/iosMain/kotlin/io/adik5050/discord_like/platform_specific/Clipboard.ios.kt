package io.adik5050.discord_like.platform_specific

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.ClipEntry

@OptIn(ExperimentalComposeUiApi::class)
actual fun String.toClipEntry() = ClipEntry.withPlainText(this)

@OptIn(ExperimentalComposeUiApi::class)
actual suspend fun ClipEntry.getText(): String? = getPlainText()