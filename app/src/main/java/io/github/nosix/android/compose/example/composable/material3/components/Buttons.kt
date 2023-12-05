package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

        val interactionSource = remember { MutableInteractionSource() }
        val isPressedAsState by interactionSource.collectIsPressedAsState()
        val isFocusedAsState by interactionSource.collectIsFocusedAsState()
        val isHoveredAsState by interactionSource.collectIsHoveredAsState()
        val isDraggedAsState by interactionSource.collectIsDraggedAsState()

        var enabled by remember { mutableStateOf(true) }

        Column {
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
                interactionSource = interactionSource
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
                val pressed = if (isPressedAsState) " pressed" else ""
                val focused = if (isFocusedAsState) " focused" else ""
                val dragged = if (isDraggedAsState) " dragged" else ""
                val hovered = if (isHoveredAsState) " hovered" else ""
                Text(text = "Button$pressed$focused$dragged$hovered")
            }

            Button(onClick = {}, enabled = enabled) {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
                Text(text = "Button")
            }

            ElevatedButton(onClick = {}, enabled = enabled) {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
                Text(text = "ElevatedButton")
            }

            FilledTonalButton(onClick = {}, enabled = enabled) {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
                Text(text = "FilledButton")
            }

            OutlinedButton(onClick = {}, enabled = enabled) {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
                Text(text = "OutlinedButton")
            }

            TextButton(onClick = {}, enabled = enabled) {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
                Text(text = "TextButton")
            }
        }
    }
}
