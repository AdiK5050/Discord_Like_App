package io.adik5050.discord_like.storage

import androidx.room.TypeConverter

class MessageTypeConverter {
    @TypeConverter
    fun messageTypeToText(type: MessageType): String {
        return type.value
    }
    @TypeConverter
    fun textToMessageType(type: String): MessageType {
        return MessageType.valueOf(type)
    }
}