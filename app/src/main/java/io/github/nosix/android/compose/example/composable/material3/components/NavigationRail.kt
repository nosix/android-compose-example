package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailDefaults
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import io.github.nosix.android.compose.example.utils.PrimaryIcon
import io.github.nosix.android.compose.example.utils.SecondaryIcon
import io.github.nosix.android.compose.example.utils.animateColorValue
import io.github.nosix.android.compose.example.utils.animateDpValue
import io.github.nosix.android.compose.example.utils.toWindowInsets

@Preview(showBackground = true, heightDp = 200)
@Composable
fun NavigationRailDemo() {
    val animateContainerColor = false
    val animateContentColor = false
    val animateWindowInsets = false

    MyTheme {
        val infiniteTransition = rememberInfiniteTransition(label = "")
        val dpValue by infiniteTransition.animateDpValue()
        val containerColor by infiniteTransition.animateColorValue(
            enabled = animateContainerColor,
            initialValue = NavigationRailDefaults.ContainerColor
        )
        val contentColor by infiniteTransition.animateColorValue(
            enabled = animateContentColor,
            initialValue = contentColorFor(NavigationRailDefaults.ContainerColor)
        )

        NavigationRail(
            containerColor = containerColor,
            contentColor = contentColor,
            header = { Text(text = "Header") },
            windowInsets = if (animateWindowInsets) dpValue.toWindowInsets() else NavigationRailDefaults.windowInsets
        ) {
            NavigationRailItem(
                selected = true,
                onClick = {},
                icon = { PrimaryIcon() },
                enabled = true,
                label = { Text(text = "Label") },
                alwaysShowLabel = true,
                colors = NavigationRailItemDefaults.colors(),
                interactionSource = remember { MutableInteractionSource() }
            )
            NavigationRailItem(
                selected = false,
                onClick = {},
                icon = { SecondaryIcon() },
                enabled = false,
                label = { Text(text = "Label") },
                alwaysShowLabel = false,
                colors = NavigationRailItemDefaults.colors(),
                interactionSource = remember { MutableInteractionSource() }
            )
        }
    }
}