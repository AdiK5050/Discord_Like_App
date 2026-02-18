package io.adik5050.discord_like.ui.app.profile.viewmodels

sealed interface UserProfileUiState {
    data object Loading : UserProfileUiState
    data class Loaded(val image: ByteArray?): UserProfileUiState {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || this::class != other::class) return false

            other as Loaded

            if (!image.contentEquals(other.image)) return false

            return true
        }

        override fun hashCode(): Int {
            return image?.contentHashCode() ?: 0
        }
    }
}

