package io.adik5050.discord_like.ui.app.profile.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun EditProfileTextField(
    modifier: Modifier = Modifier,
    value: TextFieldValue,
    label: StringResource,
    placeholder: String?,
    onTextFieldValueChange: (newValue: TextFieldValue) -> Unit,
) {
    Column (
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource( label),
            style = MaterialTheme.typography.titleSmall
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value,
            placeholder = {
                placeholder?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.alpha(0.5f)
                    )
                }
            },
            onValueChange = { newValue ->
                onTextFieldValueChange(newValue)
            },
            maxLines = 1,
            shape = MaterialTheme.shapes.large,
            textStyle = MaterialTheme.typography.bodyMedium,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            )
        )
    }
}
