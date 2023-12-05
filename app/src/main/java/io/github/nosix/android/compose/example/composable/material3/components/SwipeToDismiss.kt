package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.material3.DismissDirection
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SwipeToDismissDemo() {
    val dismissState = rememberDismissState()
    MyTheme {
        SwipeToDismiss(
            state = dismissState,
            background = {
                Text(text = "Background")
            },
            dismissContent = {
                Text(text = "DismissContent")
            },
            directions = setOf(DismissDirection.EndToStart, DismissDirection.StartToEnd)
        )
    }
}