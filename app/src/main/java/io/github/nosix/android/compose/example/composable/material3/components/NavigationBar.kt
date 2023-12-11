package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
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

@Preview(showBackground = true)
@Composable
fun NavigationBarDemo() {
    val animateContainerColor = false
    val animateContentColor = false // 変化なし
    val animateWindowInsets = false

    MyTheme {
        val infiniteTransition = rememberInfiniteTransition(label = "")
        val dpValue by infiniteTransition.animateDpValue()
        val containerColor by infiniteTransition.animateColorValue(
            enabled = animateContainerColor,
            initialValue = NavigationBarDefaults.containerColor
        )
        val contentColor by infiniteTransition.animateColorValue(
            enabled = animateContentColor,
            initialValue = contentColorFor(NavigationBarDefaults.containerColor)
        )

        NavigationBar(
            containerColor = containerColor,
            contentColor = contentColor,
            tonalElevation = NavigationBarDefaults.Elevation,
            windowInsets = if (animateWindowInsets) dpValue.toWindowInsets() else NavigationBarDefaults.windowInsets
        ) {
            NavigationBarItem(
                selected = true,
                onClick = {},
                icon = { PrimaryIcon() },
                enabled = true,
                label = { Text(text = "Label") },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(),
                interactionSource = remember { MutableInteractionSource() }
            )
            NavigationBarItem(
                selected = false,
                onClick = {},
                icon = { SecondaryIcon() },
                enabled = false,
                label = { Text(text = "Label") },
                alwaysShowLabel = false
            )
        }
    }
}