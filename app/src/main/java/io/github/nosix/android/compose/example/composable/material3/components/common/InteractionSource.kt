package io.github.nosix.android.compose.example.composable.material3.components.common

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun InteractionSourceDemo() {
    MyTheme {
        val interactionSource = remember { MutableInteractionSource() }
        val isPressedAsState by interactionSource.collectIsPressedAsState()
        val isFocusedAsState by interactionSource.collectIsFocusedAsState()
        val isHoveredAsState by interactionSource.collectIsHoveredAsState()
        val isDraggedAsState by interactionSource.collectIsDraggedAsState()

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {},
                interactionSource = interactionSource
            ) {
                val pressed = if (isPressedAsState) " pressed" else ""
                val focused = if (isFocusedAsState) " focused" else ""
                val dragged = if (isDraggedAsState) " dragged" else ""
                val hovered = if (isHoveredAsState) " hovered" else ""
                Text(text = "Button$pressed$focused$dragged$hovered")
            }
        }
    }
}