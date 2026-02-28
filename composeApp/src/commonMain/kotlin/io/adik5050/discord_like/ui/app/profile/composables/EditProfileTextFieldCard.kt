package io.adik5050.discord_like.ui.app.profile.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import io.adik5050.discord_like.ui.app.profile.EditProfileTextField
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.about_me
import myapplication.composeapp.generated.resources.display_name
import myapplication.composeapp.generated.resources.pronouns
import myapplication.composeapp.generated.resources.user_thoughts

@Composable
fun EditProfileTextFieldCard(
    modifier: Modifier = Modifier,
    username: String,
    displayName: TextFieldValue,
    pronouns: TextFieldValue,
    thoughts: TextFieldValue,
    aboutMe: TextFieldValue,
    onDisplayNameChanged: (newValue: TextFieldValue) ->  Unit,
    onPronounsChanged: (newValue: TextFieldValue) ->  Unit,
    onThoughtsChanged: (newValue: TextFieldValue) -> Unit,
    onAboutMeChanged: (newValue: TextFieldValue) ->  Unit,
) {
    Card(
        modifier = Modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    ) {
        Column (
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EditProfileTextField(
                value = displayName,
                label = Res.string.display_name,
                placeholder = username,
                onTextFieldValueChange = onDisplayNameChanged,
            )
            EditProfileTextField(
                value = pronouns,
                label = Res.string.pronouns,
                placeholder = "He/him/She/her",
                onTextFieldValueChange = onPronounsChanged,
            )
            EditProfileTextField(
                value = thoughts,
                label = Res.string.user_thoughts,
                placeholder = "How was your day?",
                onTextFieldValueChange = onThoughtsChanged,
            )
            EditProfileTextField(
                value = aboutMe,
                label = Res.string.about_me,
                placeholder = "Tell us about you",
                onTextFieldValueChange = onAboutMeChanged,
            )
        }
    }
}