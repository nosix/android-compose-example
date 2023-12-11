package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import io.github.nosix.android.compose.example.utils.PrimaryIcon
import io.github.nosix.android.compose.example.utils.SecondaryIcon

@Preview
@Composable
fun TextFieldDemo() {
    MyTheme {
        Column {
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.padding(8.dp),
                enabled = true,
                readOnly = false,
                textStyle = LocalTextStyle.current,
                label = { Text(text = "Label") },
                placeholder = { Text(text = "Placeholder") },
                leadingIcon = { PrimaryIcon() },
                trailingIcon = { SecondaryIcon() },
                prefix = { Text(text = "Prefix") },
                suffix = { Text(text = "Suffix") },
                supportingText = { Text("SupportingText") },
                isError = false,
                visualTransformation = VisualTransformation.None,
                keyboardOptions = KeyboardOptions.Default,
                keyboardActions = KeyboardActions.Default,
                singleLine = true,
                maxLines = 1,
                minLines = 1,
                interactionSource = remember { MutableInteractionSource() },
                shape = TextFieldDefaults.shape,
                colors = TextFieldDefaults.colors()
            )
            TextField(
                value = "Multiline\ntext",
                onValueChange = {},
                modifier = Modifier.padding(8.dp),
                readOnly = true,
                supportingText = { Text("SupportingText") },
                isError = true,
            )
            TextField(
                value = "Disabled",
                onValueChange = {},
                modifier = Modifier.padding(8.dp),
                enabled = false
            )
            TextField(
                value = "password",
                onValueChange = {},
                modifier = Modifier.padding(8.dp),
                visualTransformation = PasswordVisualTransformation()
            )
            TextField(
                value = "keyboardOptions",
                onValueChange = {},
                modifier = Modifier.padding(8.dp),
                keyboardOptions = KeyboardOptions(
                    autoCorrect = true,
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Go
                )
            )

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.padding(8.dp),
                enabled = true,
                readOnly = false,
                textStyle = LocalTextStyle.current,
                label = { Text(text = "Label") },
                placeholder = { Text(text = "Placeholder") },
                leadingIcon = { PrimaryIcon() },
                trailingIcon = { SecondaryIcon() },
                prefix = { Text(text = "Prefix") },
                suffix = { Text(text = "Suffix") },
                supportingText = { Text("SupportingText") },
                isError = false,
                visualTransformation = VisualTransformation.None,
                keyboardOptions = KeyboardOptions.Default,
                keyboardActions = KeyboardActions.Default,
                singleLine = false,
                maxLines = Int.MAX_VALUE,
                minLines = 1,
                interactionSource = remember { MutableInteractionSource() },
                shape = TextFieldDefaults.shape,
                colors = TextFieldDefaults.colors()
            )
        }
    }
}
