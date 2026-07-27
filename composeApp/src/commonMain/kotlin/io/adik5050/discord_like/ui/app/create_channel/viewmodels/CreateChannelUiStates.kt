package io.adik5050.discord_like.ui.app.create_channel.viewmodels

interface CreateChannelUiStates {

    data object Loading: CreateChannelUiStates
    data object Loaded: CreateChannelUiStates
    data class ChannelCreated(val channelId: Int) : CreateChannelUiStates
}