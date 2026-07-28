package io.adik5050.discord_like.storage

import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

/**
 * Fake/test data used to populate the Room database on first launch.
 *
 * Seeding only runs when the [UserEntity] table is empty, so it is safe to call
 * repeatedly (see [seedTestData]). User ids are relied upon to be 1..N because
 * inserts happen on an empty, freshly created table with an autoincrement key.
 */

@OptIn(ExperimentalEncodingApi::class)
private fun png(base64: String): ByteArray = Base64.decode(base64)

private data class SeedUser(
    val username: String,
    val password: String,
    val displayName: String,
    val pronouns: String,
    val thoughts: String?,
    val about: String?,
    val onlineStatus: String,
    val profileImage: ByteArray,
)

private data class SeedChannel(
    val name: String,
    val createdBy: Int,
    val members: List<Int>,
    val image: ByteArray,
    val messages: List<Pair<Int, String>>, // senderId to text
)

private val seedUsers = listOf(
    SeedUser(
        username = "adi8299",
        password = "Adi12345",
        displayName = "Adi",
        pronouns = "He/Him",
        thoughts = "Building a Discord clone in Compose",
        about = "KMP enthusiast. Loves clean architecture and dark themes.",
        onlineStatus = "Online",
        profileImage = png(TestImages.ADI),
    ),
    SeedUser(
        username = "therealmarko",
        password = "Marko12345",
        displayName = "Marko",
        pronouns = "He/Him",
        thoughts = "Reviewing PRs all day",
        about = "Backend by day, gamer by night.",
        onlineStatus = "Online",
        profileImage = png(TestImages.MARKO),
    ),
    SeedUser(
        username = "wazei",
        password = "Wazei12345",
        displayName = "Wazei",
        pronouns = "He/Him",
        thoughts = "brb, grabbing coffee",
        about = "Designer with a soft spot for pixel art.",
        onlineStatus = "Do Not Disturb",
        profileImage = png(TestImages.WAZEI),
    ),
    SeedUser(
        username = "sooluckyseven",
        password = "Lucky12345",
        displayName = "Sooluckyseven",
        pronouns = "He/Him",
        thoughts = "feeling lucky today",
        about = "Speedrunner. Ask me about frame data.",
        onlineStatus = "Offline",
        profileImage = png(TestImages.LUCKY),
    ),
    SeedUser(
        username = "hyuu",
        password = "Yui12345",
        displayName = "Yui",
        pronouns = "She/Her",
        thoughts = "New anime season, let's go!",
        about = "Anime club founder. Always down to talk plot.",
        onlineStatus = "Online",
        profileImage = png(TestImages.YUI),
    ),
    SeedUser(
        username = "riassexy",
        password = "Rias12345",
        displayName = "Rias",
        pronouns = "She/Her",
        thoughts = "sketching something new",
        about = "Illustrator and part-time streamer.",
        onlineStatus = "Do Not Disturb",
        profileImage = png(TestImages.RIAS),
    ),
)

private val seedChannels = listOf(
    SeedChannel(
        name = "General",
        createdBy = 1,
        members = listOf(1, 2, 3, 5),
        image = png(TestImages.GENERAL),
        messages = listOf(
            1 to "Hey everyone, welcome to the server!",
            2 to "Thanks Adi, glad to be here.",
            3 to "What are we building today?",
            5 to "A Discord-like app in Compose Multiplatform!",
        ),
    ),
    SeedChannel(
        name = "Gaming Squad",
        createdBy = 2,
        members = listOf(1, 2, 4),
        image = png(TestImages.GAMING),
        messages = listOf(
            2 to "Anyone up for a match tonight?",
            1 to "I'm in, give me 10 minutes.",
            4 to "Count me in too.",
        ),
    ),
    SeedChannel(
        name = "Anime Club",
        createdBy = 5,
        members = listOf(1, 5, 6),
        image = png(TestImages.ANIME),
        messages = listOf(
            5 to "New season drops this week!",
            6 to "Can't wait, it's going to be great.",
            1 to "Which one are you watching?",
        ),
    ),
    SeedChannel(
        name = "Adi & Marko",
        createdBy = 1,
        members = listOf(1, 2),
        image = png(TestImages.DM),
        messages = listOf(
            1 to "Hey Marko, did you review the PR?",
            2 to "Yeah, left a couple comments.",
            1 to "Awesome, thanks!",
        ),
    ),
)

/**
 * Populates the database with users, profile pictures, channels, channel members
 * and messages. No-op when users already exist.
 */
suspend fun AppDatabase.seedTestData() {
    val userDao = getUserDao()
    val channelDao = getChannelDao()
    val messageDao = getMessageDao()

    if (userDao.getAllUsers().isNotEmpty()) return

    // Users (inserted on an empty table -> ids 1..seedUsers.size in order).
    seedUsers.forEach { user ->
        userDao.insertUser(
            username = user.username,
            password = user.password,
            onlineStatus = user.onlineStatus,
            profileImage = user.profileImage,
        )
    }
    seedUsers.forEachIndexed { index, user ->
        userDao.setUserProfileInfo(
            userId = index + 1,
            displayName = user.displayName,
            pronouns = user.pronouns,
            thoughts = user.thoughts,
            about = user.about,
            profileImage = user.profileImage,
        )
    }

    // Channels, members and messages.
    seedChannels.forEach { channel ->
        val channelId = channelDao.insertAndGetChannelId(
            ChannelEntity(
                channelName = channel.name,
                userCreatedId = channel.createdBy,
                channelImage = channel.image,
            )
        )
        channel.members.forEach { memberId ->
            channelDao.insertChannelMember(channelId = channelId, memberId = memberId)
        }
        channel.messages.forEach { (senderId, text) ->
            messageDao.insertMessage(
                senderId = senderId,
                channelId = channelId,
                repliedTo = null,
                messageType = MessageType.TEXT,
                message = text.encodeToByteArray(),
            )
        }
    }
}
