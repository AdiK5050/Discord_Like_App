package io.adik5050.discord_like

import platform.UIKit.UIDevice
import io.adik5050.discord_like.platform_specific.Platform

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()