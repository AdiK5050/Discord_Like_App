package io.adik5050.discord_like.shared.composables

import androidx.compose.ui.graphics.Color
import io.adik5050.discord_like.shared.composables.OnlineStatus.ONLINE
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.edit
import myapplication.composeapp.generated.resources.status_do_not_disturb
import myapplication.composeapp.generated.resources.status_edit
import myapplication.composeapp.generated.resources.status_offline
import myapplication.composeapp.generated.resources.status_online
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class OnlineStatus(val icon: DrawableResource, val description: StringResource, val color: Color) {
    ONLINE(Res.drawable.status_online, Res.string.status_online, Color(0xff00c230)),
    DO_NOT_DISTURB(Res.drawable.status_do_not_disturb, Res.string.status_offline, Color(0xfff02d2d)),
    OFFLINE(Res.drawable.status_offline, Res.string.status_offline, Color.Gray),
    EDIT(Res.drawable.edit, Res.string.status_edit, Color.Gray)
}
fun convertToOnlineStatus(onlineStatus: String?) : OnlineStatus {
    if(onlineStatus.equals(null)) return OnlineStatus.OFFLINE
    OnlineStatus.entries.forEach {
        if(onlineStatus!!.equals(it.description)) return it
    }
    return ONLINE
}