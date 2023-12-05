package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailDefaults
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@Preview(showBackground = true)
@Composable
fun NavigationRailDemo() {
    MyTheme {
        NavigationRail(
            containerColor = NavigationRailDefaults.ContainerColor,
            contentColor = contentColorFor(NavigationRailDefaults.ContainerColor),
            header = {
                Text(text = "Header")
            },
            windowInsets = NavigationRailDefaults.windowInsets
        ) {
            NavigationRailItem(
                selected = true,
                onClick = {},
                icon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                },
                enabled = true,
                label = {
                    Text(text = "Label")
                },
                alwaysShowLabel = true,
                colors = NavigationRailItemDefaults.colors(),
                interactionSource = remember { MutableInteractionSource() }
            )
            NavigationRailItem(
                selected = false,
                onClick = {},
                icon = {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                },
                enabled = false,
                label = {
                    Text(text = "Label")
                },
                alwaysShowLabel = false,
                colors = NavigationRailItemDefaults.colors(),
                interactionSource = remember { MutableInteractionSource() }
            )
        }
    }
}