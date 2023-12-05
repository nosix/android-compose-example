package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AlertDialogDemo() {
    MyTheme {
        var showState by remember { mutableStateOf(true) }
        if (showState) {
            AlertDialog(
                onDismissRequest = {
                    showState = false
                },
                properties = DialogProperties(
                    dismissOnBackPress = true
                )
            ) {
                Text("AlertDialog")
            }
        }
    }
}