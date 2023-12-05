package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@Preview(showBackground = true)
@Composable
fun ChipDemo() {
    MyTheme {
        Column(Modifier.padding(8.dp)) {
            AssistChip(
                onClick = {},
                label = { Text("AssistChip") },
                enabled = true,
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                },
                shape = AssistChipDefaults.shape,
                colors = AssistChipDefaults.assistChipColors(),
                elevation = AssistChipDefaults.assistChipElevation(),
                border = AssistChipDefaults.assistChipBorder(),
                interactionSource = remember { MutableInteractionSource() }
            )
            ElevatedAssistChip(
                onClick = {},
                label = { Text("ElevatedAssistChip") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                },
            )
            SuggestionChip(
                onClick = {},
                label = { Text("SuggestionChip") },
                icon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                }
            )
            ElevatedSuggestionChip(
                onClick = {},
                label = { Text("ElevatedSuggestionChip") },
                icon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ExperimentalChipDemo() {
    MyTheme {
        Column(Modifier.padding(8.dp)) {
            FilterChip(
                selected = true,
                onClick = {},
                label = { Text("FilterChip") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                },
            )
            ElevatedFilterChip(
                selected = true,
                onClick = {},
                label = { Text("ElevatedFilterChip") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                },
            )
            InputChip(
                selected = true,
                onClick = {},
                label = { Text("InputChip") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                },
                avatar = {
                    Icon(imageVector = Icons.Default.AddCircle, contentDescription = null)
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                },
            )
        }
    }
}
