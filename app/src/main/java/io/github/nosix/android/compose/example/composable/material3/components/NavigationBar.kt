package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@Preview(showBackground = true)
@Composable
fun NavigationBarDemo() {
    MyTheme {
        NavigationBar(
            containerColor = NavigationBarDefaults.containerColor,
            contentColor = MaterialTheme.colorScheme.contentColorFor(NavigationBarDefaults.containerColor),
            tonalElevation = NavigationBarDefaults.Elevation,
            windowInsets = NavigationBarDefaults.windowInsets
        ) {
            NavigationBarItem(
                selected = true,
                onClick = {},
                icon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
                enabled = true,
                label = { Text(text = "Label") },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(),
                interactionSource = remember { MutableInteractionSource() }
            )
            NavigationBarItem(
                selected = false,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                enabled = false,
                label = { Text(text = "Label") },
                alwaysShowLabel = false
            )
        }
    }
}