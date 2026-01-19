package io.adik5050.discord_like.ui.app.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.shared.composables.OnlineStatus
import io.adik5050.discord_like.ui.app.profile.composables.ContentCards
import io.adik5050.discord_like.ui.app.profile.composables.ProfileInfo
import io.adik5050.discord_like.ui.app.profile.composables.TopOptions
import io.adik5050.discord_like.ui.theme.AppTheme

@Composable
fun PersonalProfilePage(

) {
    Surface (
        modifier = Modifier
            .fillMaxSize(),
        content = {
            Column (
                modifier = Modifier
                    .padding(top = 32.dp)
                    .fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    item {
                        TopOptions(
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                        )
                    }
                    item {
                        ProfileInfo(
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                            name = "Adi",
                            userId = "adi8299",
                            pronouns = "He/Him",
                            image = null,
                            clickableImage = true,
                            onClickImage = {},
                            status = OnlineStatus.ONLINE,
                            onEdit = {},
                            thoughts = "What's new in Christmas?",
                            onClickNotes = {},
                        )
                    }
                    item {
                        ContentCards(
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                            connections = true,
                            orbs = 1080,
                            about = "Change Is Fated",
                            memberSince = "Jul 9, 2024"
                        )
                    }
                    item {
                        ContentCards(
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                            connections = true,
                            orbs = 1080,
                            about = "Change Is Fated",
                            memberSince = "Jul 9, 2024"
                        )
                    }
                }
            }
        }
    )
}
@Preview
@Composable
fun PreviewPersonalProfilePage() {
    AppTheme(
        darkTheme = true
    ) {
        PersonalProfilePage()
    }
}