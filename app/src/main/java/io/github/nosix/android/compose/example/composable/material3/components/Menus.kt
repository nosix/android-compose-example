package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import io.github.nosix.android.compose.example.utils.PrimaryIcon
import io.github.nosix.android.compose.example.utils.SecondaryIcon
import io.github.nosix.android.compose.example.utils.animateDpValue
import io.github.nosix.android.compose.example.utils.toDpOffset
import io.github.nosix.android.compose.example.utils.toPaddingValues

@Preview(showBackground = true, widthDp = 320, heightDp = 160)
@Composable
fun DropdownMenuDemo() {
    val animateOffset = false
    val animateContentPadding = true

    MyTheme {
        Box {

            val infiniteTransition = rememberInfiniteTransition(label = "")
            val dpValue by infiniteTransition.animateDpValue()

            var expanded by remember { mutableStateOf(true) }
            IconButton(
                imageVector = Icons.Default.KeyboardArrowDown,
                onClick = {
                    expanded = true
                }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                offset = if (animateOffset) dpValue.toDpOffset() else DpOffset(0.dp, 0.dp),
                properties = PopupProperties(),
            ) {
                DropdownMenuItem(
                    text = { Text("Text") },
                    onClick = {},
                    leadingIcon = { PrimaryIcon() },
                    trailingIcon = { SecondaryIcon() },
                    enabled = true,
                    colors = MenuDefaults.itemColors(),
                    contentPadding = if (animateContentPadding) dpValue.toPaddingValues() else MenuDefaults.DropdownMenuItemContentPadding,
                    interactionSource = remember { MutableInteractionSource() }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, widthDp = 320, heightDp = 160)
@Composable
fun ExposedDropdownMenuBoxDemo() {
    MyTheme {
        var expanded by remember { mutableStateOf(false) }
        var value by remember { mutableStateOf("") }
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                if (it) value = ""
                expanded = it
            }
        ) {
            TextField(
                value = value,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor(),
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = {
                        Text("Text")
                    },
                    onClick = {
                        value = "Selected"
                        expanded = false
                    }
                )
            }
        }
    }
}