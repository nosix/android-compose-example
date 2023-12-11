package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedIconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import io.github.nosix.android.compose.example.utils.PrimaryIcon

@Preview(showBackground = true)
@Composable
fun IconButtonDemo() {
    MyTheme {
        Column {
            Text("IconButton")
            IconButton(
                onClick = {},
                enabled = true,
                colors = IconButtonDefaults.iconButtonColors(),
                interactionSource = remember { MutableInteractionSource() }
            ) {
                PrimaryIcon()
            }

            Text("FilledIconButton")
            FilledIconButton(onClick = {}) {
                PrimaryIcon()
            }

            Text("FilledTonalIconButton")
            FilledTonalIconButton(onClick = {}) {
                PrimaryIcon()
            }

            Text("OutlinedIconButton")
            OutlinedIconButton(onClick = {}) {
                PrimaryIcon()
            }

            Text("IconToggleButton")
            var iconToggleChecked by remember { mutableStateOf(false) }
            IconToggleButton(
                checked = iconToggleChecked,
                onCheckedChange = { iconToggleChecked = it },
                enabled = true,
                colors = IconButtonDefaults.iconToggleButtonColors(),
                interactionSource = remember { MutableInteractionSource() }
            ) {
                PrimaryIcon()
            }

            Text("FilledIconToggleButton")
            FilledIconToggleButton(
                checked = iconToggleChecked,
                onCheckedChange = { iconToggleChecked = it }
            ) {
                PrimaryIcon()
            }

            Text("FilledTonalIconToggleButton")
            FilledTonalIconToggleButton(
                checked = iconToggleChecked,
                onCheckedChange = { iconToggleChecked = it }
            ) {
                PrimaryIcon()
            }

            Text("OutlinedIconToggleButton")
            OutlinedIconToggleButton(
                checked = iconToggleChecked,
                onCheckedChange = { iconToggleChecked = it }
            ) {
                PrimaryIcon()
            }
        }
    }
}
