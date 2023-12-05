package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun SnackbarDemo() {
    MyTheme {
        Column {
            val scope = rememberCoroutineScope()
            val snackbarHostState = remember { SnackbarHostState() }
            IconButton(
                imageVector = Icons.Default.KeyboardArrowUp,
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Snackbar",
                            actionLabel = "ActionLabel",
                            withDismissAction = true,
                            duration = SnackbarDuration.Long
                        )
                    }
                }
            )
            SnackbarHost(snackbarHostState) { snackbarData ->
                Snackbar(
                    snackbarData = snackbarData,
                    actionOnNewLine = true,
                    shape = SnackbarDefaults.shape,
                    containerColor = SnackbarDefaults.color,
                    contentColor = SnackbarDefaults.contentColor,
                    actionColor = SnackbarDefaults.actionColor,
                    actionContentColor = SnackbarDefaults.actionContentColor,
                    dismissActionContentColor = SnackbarDefaults.dismissActionContentColor
                )
            }
        }
    }
}