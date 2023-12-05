package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
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
import io.github.nosix.android.compose.example.utils.animateDpValue

@Preview(showBackground = true)
@Composable
fun DropdownMenuDemo() {
    val animateOffset = false
    MyTheme {
        val infiniteTransition = rememberInfiniteTransition(label = "")
        val dpState by infiniteTransition.animateDpValue()

        var expanded by remember { mutableStateOf(false) }
        IconButton(
            imageVector = Icons.Default.KeyboardArrowDown,
            onClick = {
                expanded = true
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = if (animateOffset) DpOffset(dpState, dpState) else DpOffset(0.dp, 0.dp),
            properties = PopupProperties(focusable = true),
        ) {
            DropdownMenuItem(
                text = {
                    Text("Item 1")
                },
                onClick = {},
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                },
                enabled = true,
                colors = MenuDefaults.itemColors(),
                contentPadding = MenuDefaults.DropdownMenuItemContentPadding,
                interactionSource = remember { MutableInteractionSource() }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ExposedDropdownMenuBoxDemo() {
    MyTheme {
        var expanded by remember { mutableStateOf(false) }
        var value by remember { mutableStateOf("") }
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = it
            }
        ) {
            TextField(
                value = value,
                onValueChange = {},
                modifier = Modifier.menuAnchor(),
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
                        Text("Item 1")
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