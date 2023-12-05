package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@Preview(showBackground = true)
@Composable
fun RadioButtonDemo() {
    MyTheme {
        Row {
            RadioButton(
                selected = true,
                onClick = {},
                enabled = true,
                colors = RadioButtonDefaults.colors(),
                interactionSource = remember { MutableInteractionSource() }
            )
            RadioButton(
                selected = false,
                onClick = {},
                enabled = false
            )
        }
    }
}