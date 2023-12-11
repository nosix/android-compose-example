package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import kotlinx.coroutines.launch

@Preview(showBackground = true, widthDp = 320)
@Composable
fun SnackbarDemo() {
    MyTheme {
        Column {
            val scope = rememberCoroutineScope()
            val snackbarHostState = remember { SnackbarHostState() }
            var targetColor by remember { mutableIntStateOf(0) }

            Row {
                for (target in (1..5)) {
                    IconButton(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        onClick = {
                            targetColor = target
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    message = "Snackbar",
                                    actionLabel = "ActionLabel",
                                    withDismissAction = true,
                                    duration = SnackbarDuration.Short
                                )
                            }
                        }
                    )
                }
            }

            SnackbarHost(snackbarHostState) { snackbarData ->
                Snackbar(
                    snackbarData = snackbarData,
                    actionOnNewLine = true,
                    shape = SnackbarDefaults.shape,
                    containerColor = if (targetColor == 1) Color.Red else SnackbarDefaults.color,
                    contentColor = if (targetColor == 2) Color.Red else SnackbarDefaults.contentColor,
                    actionColor = if (targetColor == 3) Color.Red else SnackbarDefaults.actionColor,
                    actionContentColor = if (targetColor == 4) Color.Red else SnackbarDefaults.actionContentColor,
                    dismissActionContentColor = if (targetColor == 5) Color.Red else SnackbarDefaults.dismissActionContentColor
                )
            }
            SnackbarHost(snackbarHostState) {
                Snackbar(
                    modifier = Modifier.padding(8.dp),
                    action = {
                        Text(text = "Action")
                    },
                    dismissAction = {
                        Text(text = "DismissAction")
                    },
                    actionOnNewLine = true,
                    shape = SnackbarDefaults.shape,
                    containerColor = if (targetColor == 1) Color.Red else SnackbarDefaults.color,
                    contentColor = if (targetColor == 2) Color.Red else SnackbarDefaults.contentColor,
                    actionContentColor = if (targetColor == 4) Color.Red else SnackbarDefaults.actionContentColor,
                    dismissActionContentColor = if (targetColor == 5) Color.Red else SnackbarDefaults.dismissActionContentColor
                ) {
                    Text(text = "Content")
                }
            }
        }
    }
}
