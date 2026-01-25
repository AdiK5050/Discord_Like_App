package io.adik5050.discord_like.ui.app.login.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.visibility_off
import myapplication.composeapp.generated.resources.visibility_on
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginTextField(
    modifier: Modifier = Modifier,
    label: StringResource,
    textFieldValue: TextFieldValue,
    onTextFieldValueChange: (newValue: TextFieldValue) -> Unit,
    visualTransformation: Boolean,
) {
    var visibility by remember { mutableStateOf(visualTransformation) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = stringResource(label),
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Start
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Transparent)
                .heightIn(min = 48.dp),
            value = textFieldValue,
            onValueChange = { newValue ->
                onTextFieldValueChange(newValue)
            },
            maxLines = 1,
            shape = MaterialTheme.shapes.large,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest.copy(alpha = 0.5f),
                unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest.copy(alpha = 0.5f),
                focusedIndicatorColor = MaterialTheme.colorScheme.surfaceContainerLowest.copy(alpha = 0.5f),
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surfaceContainerLowest.copy(alpha = 0.5f)
            ),
            visualTransformation = if (visibility) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = @Composable {
                if(visualTransformation)
                IconButton(
                    onClick = { visibility = !visibility },
                    content = {
                        Icon(
                            modifier = Modifier.size(16.dp),
                            painter = if (visibility) painterResource(Res.drawable.visibility_off)
                            else painterResource(Res.drawable.visibility_on),
                            contentDescription = "visibility",
                        )
                    }
                )
            }
        )

    }
}