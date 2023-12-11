package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.InputChip
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import io.github.nosix.android.compose.example.utils.PrimaryIcon
import io.github.nosix.android.compose.example.utils.SecondaryIcon
import io.github.nosix.android.compose.example.utils.TertiaryIcon

@Preview(showBackground = true, widthDp = 240)
@Composable
fun ChipDemo() {
    MyTheme {
        Column(Modifier.padding(8.dp)) {
            AssistChip(
                onClick = {},
                label = { Text("AssistChip") },
                modifier = Modifier.fillMaxWidth(),
                enabled = false,
                leadingIcon = { PrimaryIcon() },
                trailingIcon = { SecondaryIcon() },
                shape = AssistChipDefaults.shape,
                colors = AssistChipDefaults.assistChipColors(),
                elevation = AssistChipDefaults.assistChipElevation(),
                border = AssistChipDefaults.assistChipBorder(),
                interactionSource = remember { MutableInteractionSource() }
            )
            AssistChip(
                onClick = {},
                label = { Text("AssistChip") },
                leadingIcon = { PrimaryIcon() },
                trailingIcon = { SecondaryIcon() },
            )
            ElevatedAssistChip(
                onClick = {},
                label = { Text("ElevatedAssistChip") },
                leadingIcon = { PrimaryIcon() },
                trailingIcon = { SecondaryIcon() },
            )
            SuggestionChip(
                onClick = {},
                label = { Text("SuggestionChip") },
                icon = { PrimaryIcon() }
            )
            ElevatedSuggestionChip(
                onClick = {},
                label = { Text("ElevatedSuggestionChip") },
                icon = { PrimaryIcon() }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, widthDp = 240)
@Composable
fun ExperimentalChipDemo() {
    MyTheme {
        Column(Modifier.padding(8.dp)) {
            FilterChip(
                selected = true,
                onClick = {},
                label = { Text("FilterChip") },
                leadingIcon = { PrimaryIcon() },
                trailingIcon = { SecondaryIcon() },
            )
            ElevatedFilterChip(
                selected = true,
                onClick = {},
                label = { Text("ElevatedFilterChip") },
                leadingIcon = { PrimaryIcon() },
                trailingIcon = { SecondaryIcon() },
            )
            InputChip(
                selected = true,
                onClick = {},
                label = { Text("InputChip") },
                leadingIcon = { PrimaryIcon() },
                avatar = { TertiaryIcon() },
                trailingIcon = { SecondaryIcon() },
            )
        }
    }
}
