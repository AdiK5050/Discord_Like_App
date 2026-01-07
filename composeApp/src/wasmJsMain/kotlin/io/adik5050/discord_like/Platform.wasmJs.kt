package io.adik5050.discord_like

import io.adik5050.discord_like.platform_specific.Platform

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = WasmPlatform()