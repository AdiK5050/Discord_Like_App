package io.adik5050.discord_like

import io.adik5050.discord_like.platform_specific.Platform

class JsPlatform: Platform {
    override val name: String = "Web with Kotlin/JS"
}

actual fun getPlatform(): Platform = JsPlatform()