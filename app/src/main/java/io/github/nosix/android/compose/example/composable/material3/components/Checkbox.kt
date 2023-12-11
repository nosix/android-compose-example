package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@Preview(showBackground = true)
@Composable
fun CheckboxDemo() {
    MyTheme {
        Row {
            var checked by remember { mutableStateOf(false) }
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it },
                enabled = true,
                colors = CheckboxDefaults.colors(),
                interactionSource = remember { MutableInteractionSource() }
            )

            var triState by remember { mutableStateOf(ToggleableState.Off) }
            TriStateCheckbox(
                state = triState,
                onClick = {
                    triState = when (triState) {
                        ToggleableState.Off -> ToggleableState.Indeterminate
                        ToggleableState.Indeterminate -> ToggleableState.On
                        ToggleableState.On -> ToggleableState.Off
                    }
                }
            )
        }
    }
}
