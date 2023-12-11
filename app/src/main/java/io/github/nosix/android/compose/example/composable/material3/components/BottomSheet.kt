package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import io.github.nosix.android.compose.example.utils.animateColorValue
import io.github.nosix.android.compose.example.utils.animateDpValue
import io.github.nosix.android.compose.example.utils.toWindowInsets
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun BottomSheetPartiallyExpandedDemo() {
    val animateSheetPeekHeight = false
    val animateSheetTonalElevation = false
    val animateSheetShadowElevation = false
    val animateContainerColor = false
    val animateContentColor = true

    MyTheme {
        val bottomSheetState = rememberBottomSheetScaffoldState(
            rememberStandardBottomSheetState(
                initialValue = SheetValue.PartiallyExpanded,
            )
        )
        val infiniteTransition = rememberInfiniteTransition(label = "")
        val dpValue by infiniteTransition.animateDpValue()
        val containerColor by infiniteTransition.animateColorValue(
            enabled = animateContainerColor,
            initialValue = MaterialTheme.colorScheme.surface
        )
        val contentColor by infiniteTransition.animateColorValue(
            enabled = animateContentColor,
            initialValue = contentColorFor(MaterialTheme.colorScheme.surface)
        )

        BottomSheetScaffold(
            sheetContent = {
                Column {
                    Text(text = "SheetContent")
                }
            },
            scaffoldState = bottomSheetState,
            sheetPeekHeight = if (animateSheetPeekHeight) dpValue else BottomSheetDefaults.SheetPeekHeight,
            sheetShape = BottomSheetDefaults.ExpandedShape,
            sheetContainerColor = BottomSheetDefaults.ContainerColor,
            sheetContentColor = contentColorFor(BottomSheetDefaults.ContainerColor),
            sheetTonalElevation = if (animateSheetTonalElevation) dpValue else BottomSheetDefaults.Elevation,
            sheetShadowElevation = if (animateSheetShadowElevation) dpValue else BottomSheetDefaults.Elevation,
            sheetDragHandle = { BottomSheetDefaults.DragHandle() },
            sheetSwipeEnabled = true,
            topBar = {
                Column {
                    Text("TopBar")
                }
            },
            snackbarHost = { SnackbarHost(it) },
            containerColor = containerColor,
            contentColor = contentColor,
        ) {
            Text(text = "Content")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun BottomSheetDemo() {
    val animateSheetContainerColor = false
    val animateSheetContentColor = false

    MyTheme {
        val scope = rememberCoroutineScope()
        val bottomSheetState = rememberBottomSheetScaffoldState(
            rememberStandardBottomSheetState(
                initialValue = SheetValue.Expanded,
                skipHiddenState = false // hide 使用時は必須
            )
        )
        val infiniteTransition = rememberInfiniteTransition(label = "")
        val sheetContainerColor by infiniteTransition.animateColorValue(
            enabled = animateSheetContainerColor,
            initialValue = BottomSheetDefaults.ContainerColor
        )
        val sheetContentColor by infiniteTransition.animateColorValue(
            enabled = animateSheetContentColor,
            initialValue = contentColorFor(BottomSheetDefaults.ContainerColor)
        )

        BottomSheetScaffold(
            sheetContent = {
                Text(text = "SheetContent")
            },
            scaffoldState = bottomSheetState,
            sheetContainerColor = sheetContainerColor,
            sheetContentColor = sheetContentColor,
            topBar = {
                Row {
                    IconButton(Icons.Default.KeyboardArrowUp) {
                        scope.launch { bottomSheetState.bottomSheetState.expand() }
                    }
                    IconButton(Icons.Default.KeyboardArrowDown) {
                        scope.launch { bottomSheetState.bottomSheetState.partialExpand() }
                    }
                    IconButton(Icons.Default.KeyboardArrowUp) {
                        scope.launch { bottomSheetState.bottomSheetState.show() }
                    }
                    IconButton(Icons.Default.KeyboardArrowDown) {
                        scope.launch { bottomSheetState.bottomSheetState.hide() }
                    }
                }
            },
        ) {
            Column {
                Text("currentValue: ${bottomSheetState.bottomSheetState.currentValue}")
                Text("targetValue: ${bottomSheetState.bottomSheetState.targetValue}")
                Text("hasPartiallyExpandedState: ${bottomSheetState.bottomSheetState.hasPartiallyExpandedState}")
                Text("hasExpandedState: ${bottomSheetState.bottomSheetState.hasExpandedState}")
                Text("isVisible: ${bottomSheetState.bottomSheetState.isVisible}")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun ModalBottomSheetDemo() {
    val animateTonalElevation = false
    val animateContainerColor = false
    val animateContentColor = false
    val animateScrimColor = false
    val animateWindowInsets = false

    MyTheme {
        val scope = rememberCoroutineScope()
        val bottomSheetState = rememberModalBottomSheetState()
        val infiniteTransition = rememberInfiniteTransition(label = "")
        val dpValue by infiniteTransition.animateDpValue()
        val containerColor by infiniteTransition.animateColorValue(
            enabled = animateContainerColor,
            initialValue = BottomSheetDefaults.ContainerColor
        )
        val contentColor by infiniteTransition.animateColorValue(
            enabled = animateContentColor,
            initialValue = contentColorFor(BottomSheetDefaults.ContainerColor)
        )
        val scrimColor by infiniteTransition.animateColorValue(
            enabled = animateScrimColor,
            initialValue = BottomSheetDefaults.ScrimColor
        )
        var openBottomSheet by remember { mutableStateOf(true) }

        Column {
            IconButton(Icons.Default.KeyboardArrowUp) {
                openBottomSheet = true
            }
            Text("currentValue: ${bottomSheetState.currentValue}")
            Text("targetValue: ${bottomSheetState.targetValue}")
            Text("hasPartiallyExpandedState: ${bottomSheetState.hasPartiallyExpandedState}")
            Text("hasExpandedState: ${bottomSheetState.hasExpandedState}")
            Text("isVisible: ${bottomSheetState.isVisible}")
        }

        if (openBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    openBottomSheet = false
                },
                modifier = Modifier.fillMaxSize(),
                sheetState = bottomSheetState,
                shape = BottomSheetDefaults.ExpandedShape,
                containerColor = containerColor,
                contentColor = contentColor,
                tonalElevation = if (animateTonalElevation) dpValue else BottomSheetDefaults.Elevation,
                scrimColor = scrimColor,
                dragHandle = { BottomSheetDefaults.DragHandle() },
                windowInsets = if (animateWindowInsets) dpValue.toWindowInsets() else BottomSheetDefaults.windowInsets
            ) {
                Column {
                    Row {
                        IconButton(Icons.Default.KeyboardArrowUp) {
                            scope.launch { bottomSheetState.expand() }
                        }
                        IconButton(Icons.Default.KeyboardArrowDown) {
                            scope.launch { bottomSheetState.partialExpand() }
                        }
                        IconButton(Icons.Default.KeyboardArrowUp) {
                            scope.launch { bottomSheetState.show() }
                        }
                        IconButton(Icons.Default.KeyboardArrowDown) {
                            scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                                if (!bottomSheetState.isVisible) openBottomSheet = false
                            }
                        }
                    }
                    Text("currentValue: ${bottomSheetState.currentValue}")
                    Text("targetValue: ${bottomSheetState.targetValue}")
                    Text("hasPartiallyExpandedState: ${bottomSheetState.hasPartiallyExpandedState}")
                    Text("hasExpandedState: ${bottomSheetState.hasExpandedState}")
                    Text("isVisible: ${bottomSheetState.isVisible}")
                }
            }
        }
    }
}

@Composable
fun IconButton(imageVector: ImageVector, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(imageVector = imageVector, contentDescription = null)
    }
}