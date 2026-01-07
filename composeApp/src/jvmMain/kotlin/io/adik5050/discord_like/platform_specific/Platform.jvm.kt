package io.adik5050.discord_like.platform_specific

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}
actual fun getPlatform(): Platform = JVMPlatform()