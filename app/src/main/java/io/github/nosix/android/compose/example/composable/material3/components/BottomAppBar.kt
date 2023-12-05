package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import io.github.nosix.android.compose.example.utils.animateDpValue
import io.github.nosix.android.compose.example.utils.toPaddingValues
import io.github.nosix.android.compose.example.utils.toWindowInsets

@Preview(showBackground = true)
@Composable
fun BottomAppBarDemo() {
    val animateTonalElevation = false
    val animateContentPadding = false
    val animateWindowInsets = false

    MyTheme {
        val dpValue by rememberInfiniteTransition(label = "").animateDpValue()

        BottomAppBar(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            tonalElevation = if (animateTonalElevation) dpValue else BottomAppBarDefaults.ContainerElevation,
            contentPadding = if (animateContentPadding) dpValue.toPaddingValues() else BottomAppBarDefaults.ContentPadding,
            windowInsets = if (animateWindowInsets) dpValue.toWindowInsets() else BottomAppBarDefaults.windowInsets
        ) {
            BottomIconButton(imageVector = Icons.Default.Email)
            BottomIconButton(imageVector = Icons.Default.AccountCircle)
            BottomIconButton(imageVector = Icons.Default.Build)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomAppBarDemo2() {
    MyTheme {
        BottomAppBar(
            actions = {
                BottomIconButton(imageVector = Icons.Default.Email)
                BottomIconButton(imageVector = Icons.Default.AccountCircle)
                BottomIconButton(imageVector = Icons.Default.Build)
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {},
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            },
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            tonalElevation = BottomAppBarDefaults.ContainerElevation,
            contentPadding = BottomAppBarDefaults.ContentPadding,
            windowInsets = BottomAppBarDefaults.windowInsets
        )
    }
}

@Composable
fun BottomIconButton(imageVector: ImageVector) {
    IconButton(onClick = {}) {
        Icon(imageVector = imageVector, contentDescription = null)
    }
}