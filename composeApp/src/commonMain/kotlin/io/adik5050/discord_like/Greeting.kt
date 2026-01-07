package io.adik5050.discord_like

import io.adik5050.discord_like.platform_specific.getPlatform

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}