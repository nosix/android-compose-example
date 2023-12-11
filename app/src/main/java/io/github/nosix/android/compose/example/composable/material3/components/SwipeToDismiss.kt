package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.material3.DismissDirection
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, widthDp = 320, heightDp = 160)
@Composable
fun SwipeToDismissDemo() {
    val dismissState = rememberDismissState()
    MyTheme {
        SwipeToDismiss(
            state = dismissState,
            background = {
                Surface(color = Color.Gray) {
                    Text(text = "Background")
                }
            },
            dismissContent = {
                Surface(color = Color.LightGray) {
                    Text(text = "DismissContent")
                }
            },
            directions = setOf(DismissDirection.EndToStart, DismissDirection.StartToEnd)
        )
    }
}