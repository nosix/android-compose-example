package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import io.github.nosix.android.compose.example.utils.animateDpValue
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun BottomSheetDemo() {
    val animateSheetPeekHeight = false
    val animateSheetTonalElevation = false
    val animateSheetShadowElevation = false

    MyTheme {
        val dpValue by rememberInfiniteTransition(label = "").animateDpValue()
        val bottomSheetState = rememberBottomSheetScaffoldState()
        val coroutineScope = rememberCoroutineScope()

        BottomSheetScaffold(
            sheetContent = {
                Column {
                    Text("SheetContent")
                    IconButton(Icons.Default.KeyboardArrowDown) {
                        coroutineScope.launch { bottomSheetState.bottomSheetState.partialExpand() }
                    }
                }
            },
            scaffoldState = bottomSheetState,
            sheetPeekHeight = if (animateSheetPeekHeight) dpValue else BottomSheetDefaults.SheetPeekHeight,
            sheetShape = BottomSheetDefaults.ExpandedShape,
            sheetContainerColor = MaterialTheme.colorScheme.primaryContainer,
            sheetContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            sheetTonalElevation = if (animateSheetTonalElevation) dpValue else BottomSheetDefaults.Elevation,
            sheetShadowElevation = if (animateSheetShadowElevation) dpValue else BottomSheetDefaults.Elevation,
            sheetDragHandle = { BottomSheetDefaults.DragHandle() },
            sheetSwipeEnabled = true,
            topBar = {
                Row {
                    IconButton(Icons.Default.KeyboardArrowUp) {
                        coroutineScope.launch { bottomSheetState.bottomSheetState.expand() }
                    }
                    IconButton(Icons.Default.KeyboardArrowDown) {
                        coroutineScope.launch { bottomSheetState.bottomSheetState.partialExpand() }
                    }
                    IconButton(Icons.Default.KeyboardArrowUp) {
                        coroutineScope.launch { bottomSheetState.bottomSheetState.show() }
                    }
                    IconButton(Icons.Default.KeyboardArrowDown) {
                        coroutineScope.launch { bottomSheetState.bottomSheetState.hide() }
                    }
                }
            },
            snackbarHost = { SnackbarHost(it) },
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface,
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
@Preview(showBackground = true)
@Composable
fun ModalBottomSheetDemo() {
    MyTheme {
        var openBottomSheet by remember { mutableStateOf(false) }
        val bottomSheetState = rememberModalBottomSheetState()
        val coroutineScope = rememberCoroutineScope()

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
                onDismissRequest = { openBottomSheet = false },
                sheetState = bottomSheetState,
                shape = BottomSheetDefaults.ExpandedShape,
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                tonalElevation = BottomSheetDefaults.Elevation,
                scrimColor = MaterialTheme.colorScheme.scrim,
                dragHandle = { BottomSheetDefaults.DragHandle() },
                windowInsets = BottomSheetDefaults.windowInsets
            ) {
                Column {
                    Text("SheetContent")
                    Row {
                        IconButton(Icons.Default.KeyboardArrowDown) {
                            coroutineScope.launch { bottomSheetState.hide() }.invokeOnCompletion {
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