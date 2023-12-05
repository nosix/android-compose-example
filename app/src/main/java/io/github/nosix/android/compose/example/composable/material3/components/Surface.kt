package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@Preview(showBackground = true)
@Composable
fun SurfaceDemo() {
    MyTheme {
        Surface(
            modifier = Modifier.padding(8.dp),
            shape = RectangleShape,
            color = MaterialTheme.colorScheme.surface,
            contentColor = contentColorFor(MaterialTheme.colorScheme.surface),
            tonalElevation = 0.dp,
            shadowElevation = 0.dp,
            border = BorderStroke(4.dp, color = MaterialTheme.colorScheme.primary),
        ) {
            Text(text = "Content")
        }
    }
}