package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import io.github.nosix.android.compose.example.utils.animateDpValue
import io.github.nosix.android.compose.example.utils.toPaddingValues

@Preview(showBackground = true)
@Composable
fun ButtonDemo() {
    val animateElevation = false
    val animateContentPadding = false

    MyTheme {
        val infiniteTransition = rememberInfiniteTransition(label = "")
        val dpState by infiniteTransition.animateDpValue()

        var enabled by remember { mutableStateOf(true) }

        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { enabled = !enabled },
                enabled = true,
                shape = ButtonDefaults.shape,
                colors = ButtonDefaults.buttonColors(),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = if (animateElevation) dpState else 0.dp
                ),
                border = ButtonDefaults.outlinedButtonBorder,
                contentPadding = if (animateContentPadding) dpState.toPaddingValues() else ButtonDefaults.ContentPadding,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                Text(text = if (enabled) "Enabled" else "Disabled")
            }

            Button(onClick = {}, enabled = enabled) {
                Text(text = "Button")
            }

            ElevatedButton(onClick = {}, enabled = enabled) {
                Text(text = "ElevatedButton")
            }

            FilledTonalButton(onClick = {}, enabled = enabled) {
                Text(text = "FilledButton")
            }

            OutlinedButton(onClick = {}, enabled = enabled) {
                Text(text = "OutlinedButton")
            }

            TextButton(onClick = {}, enabled = enabled) {
                Text(text = "TextButton")
            }
        }
    }
}
