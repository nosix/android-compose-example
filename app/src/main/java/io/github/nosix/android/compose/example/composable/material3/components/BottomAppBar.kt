package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import io.github.nosix.android.compose.example.utils.PrimaryIcon
import io.github.nosix.android.compose.example.utils.SecondaryIcon
import io.github.nosix.android.compose.example.utils.TertiaryIcon
import io.github.nosix.android.compose.example.utils.animateColorValue
import io.github.nosix.android.compose.example.utils.animateDpValue
import io.github.nosix.android.compose.example.utils.toPaddingValues
import io.github.nosix.android.compose.example.utils.toWindowInsets

@Preview(showBackground = true)
@Composable
fun BottomAppBarDemo() {
    MyTheme {
        BottomAppBar(
            modifier = Modifier.padding(8.dp),
            containerColor = BottomAppBarDefaults.containerColor,
            contentColor = contentColorFor(BottomAppBarDefaults.containerColor),
            tonalElevation = BottomAppBarDefaults.ContainerElevation,
            contentPadding = BottomAppBarDefaults.ContentPadding,
            windowInsets = BottomAppBarDefaults.windowInsets
        ) {
            IconButton(index = 1)
            IconButton(index = 2)
            IconButton(index = 3)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomAppBarWithFabDemo() {
    val animateContainerColor = false
    val animateContentColor = false
    val animateTonalElevation = false
    val animateContentPadding = false
    val animateWindowInsets = false

    MyTheme {
        val infiniteTransition = rememberInfiniteTransition(label = "")
        val dpValue by infiniteTransition.animateDpValue()
        val containerColor by infiniteTransition.animateColorValue(
            enabled = animateContainerColor,
            initialValue = BottomAppBarDefaults.containerColor
        )
        val contentColor by infiniteTransition.animateColorValue(
            enabled = animateContentColor,
            initialValue = contentColorFor(BottomAppBarDefaults.containerColor)
        )

        BottomAppBar(
            actions = {
                IconButton(index = 1)
                IconButton(index = 2)
                IconButton(index = 3)
            },
            modifier = Modifier.padding(8.dp),
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {},
                    containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                    contentColor = contentColorFor(FloatingActionButtonDefaults.containerColor)
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            },
            containerColor = containerColor,
            contentColor = contentColor,
            tonalElevation = if (animateTonalElevation) dpValue else BottomAppBarDefaults.ContainerElevation,
            contentPadding = if (animateContentPadding) dpValue.toPaddingValues() else BottomAppBarDefaults.ContentPadding,
            windowInsets = if (animateWindowInsets) dpValue.toWindowInsets() else BottomAppBarDefaults.windowInsets
        )
    }
}

@Composable
fun IconButton(index: Int) {
    IconButton(onClick = {}) {
        when (index) {
            1 -> PrimaryIcon()
            2 -> SecondaryIcon()
            3 -> TertiaryIcon()
        }
    }
}