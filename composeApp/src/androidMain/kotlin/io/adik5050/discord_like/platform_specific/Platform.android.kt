package io.adik5050.discord_like.platform_specific

import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}
actual fun getPlatform(): Platform = AndroidPlatform()