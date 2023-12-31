package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Badge
import androidx.compose.material3.DismissibleDrawerSheet
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import io.github.nosix.android.compose.example.utils.PrimaryIcon
import io.github.nosix.android.compose.example.utils.animateColorValue
import io.github.nosix.android.compose.example.utils.animateDpValue
import io.github.nosix.android.compose.example.utils.toWindowInsets
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, heightDp = 160)
@Composable
fun ModalNavigationDrawerDemo() {
    val animateDrawerContainerColor = false
    val animateDrawerContentColor = false // 変化なし
    val animateScrimColor = false
    val animateWindowInsets = false

    MyTheme {
        val scope = rememberCoroutineScope()
        val drawerState = rememberDrawerState(DrawerValue.Open)
        val infiniteTransition = rememberInfiniteTransition(label = "")
        val dpValue by infiniteTransition.animateDpValue()
        val drawerContainer by infiniteTransition.animateColorValue(
            enabled = animateDrawerContainerColor,
            initialValue = MaterialTheme.colorScheme.surface
        )
        val drawerContent by infiniteTransition.animateColorValue(
            enabled = animateDrawerContentColor,
            initialValue = contentColorFor(MaterialTheme.colorScheme.surface)
        )
        val scrimColor by infiniteTransition.animateColorValue(
            enabled = animateScrimColor,
            initialValue = DrawerDefaults.scrimColor
        )

        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet(
                    drawerShape = DrawerDefaults.shape,
                    drawerContainerColor = drawerContainer,
                    drawerContentColor = drawerContent,
                    drawerTonalElevation = DrawerDefaults.ModalDrawerElevation,
                    windowInsets = if (animateWindowInsets) dpValue.toWindowInsets() else DrawerDefaults.windowInsets
                ) {
                    NavigationDrawerItem(
                        label = { Text("Label") },
                        selected = true,
                        onClick = {},
                        icon = { PrimaryIcon() },
                        badge = {
                            Badge {
                                Text(text = "10")
                            }
                        },
                        shape = MaterialTheme.shapes.medium,
                        colors = NavigationDrawerItemDefaults.colors(),
                        interactionSource = remember { MutableInteractionSource() }
                    )
                }
            },
            drawerState = drawerState,
            gesturesEnabled = true,
            scrimColor = scrimColor,
        ) {
            IconButton(
                imageVector = Icons.Default.KeyboardArrowDown,
                onClick = {
                    scope.launch {
                        drawerState.open()
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true, heightDp = 160)
@Composable
fun PermanentNavigationDrawerDemo() {
    MyTheme {
        PermanentNavigationDrawer(
            drawerContent = {
                PermanentDrawerSheet(
                    drawerShape = RectangleShape,
                    drawerContainerColor = MaterialTheme.colorScheme.surface,
                    drawerContentColor = contentColorFor(MaterialTheme.colorScheme.surface),
                    drawerTonalElevation = DrawerDefaults.PermanentDrawerElevation,
                    windowInsets = DrawerDefaults.windowInsets
                ) {
                    NavigationDrawerItem(
                        label = { Text("Label") },
                        selected = true,
                        onClick = {}
                    )
                }
            }
        ) {
            Text(text = "Content")
        }
    }
}

@Preview(showBackground = true, heightDp = 160)
@Composable
fun DismissibleNavigationDrawerDemo() {
    MyTheme {
        val scope = rememberCoroutineScope()
        val drawerState = rememberDrawerState(DrawerValue.Open)

        DismissibleNavigationDrawer(
            drawerContent = {
                DismissibleDrawerSheet(
                    drawerShape = DrawerDefaults.shape,
                    drawerContainerColor = MaterialTheme.colorScheme.surface,
                    drawerContentColor = contentColorFor(MaterialTheme.colorScheme.surface),
                    drawerTonalElevation = DrawerDefaults.ModalDrawerElevation,
                    windowInsets = DrawerDefaults.windowInsets
                ) {
                    NavigationDrawerItem(
                        label = { Text("Label") },
                        selected = true,
                        onClick = {}
                    )
                }
            },
            drawerState = drawerState,
            gesturesEnabled = true,
        ) {
            Row(Modifier.fillMaxWidth()) {
                IconButton(
                    imageVector = if (drawerState.isOpen) Icons.Default.Close else Icons.Default.KeyboardArrowDown,
                    onClick = {
                        scope.launch {
                            if (drawerState.isOpen) drawerState.close() else drawerState.open()
                        }
                    }
                )
            }
        }
    }
}