package io.adik5050.discord_like.platform_specific

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform