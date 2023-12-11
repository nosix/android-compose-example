package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
fun SwitchDemo() {
    MyTheme {
        var checked by remember { mutableStateOf(false) }
        Switch(
            checked = checked,
            onCheckedChange = { checked = it },
            thumbContent = { PrimaryIcon() },
            enabled = true,
            colors = SwitchDefaults.colors(),
            interactionSource = remember { MutableInteractionSource() }
        )
    }
}