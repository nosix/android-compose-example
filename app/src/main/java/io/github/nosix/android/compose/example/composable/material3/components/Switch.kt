package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@Preview(showBackground = true)
@Composable
fun SwitchDemo() {
    MyTheme {
        Switch(
            checked = true,
            onCheckedChange = {},
            thumbContent = {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
            },
            enabled = true,
            colors = SwitchDefaults.colors(),
            interactionSource = remember { MutableInteractionSource() }
        )
    }
}