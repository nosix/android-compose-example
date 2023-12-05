package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.nosix.android.compose.example.ui.theme.MyTheme

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
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
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
        }
    }
}

@Preview
@Composable
fun OutlinedTextFieldDemo() {
    MyTheme {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.padding(8.dp),
            enabled = true,
            readOnly = false,
            textStyle = LocalTextStyle.current,
            label = { Text(text = "Label") },
            placeholder = { Text(text = "Placeholder") },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
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