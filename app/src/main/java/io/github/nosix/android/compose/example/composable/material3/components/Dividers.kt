package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@Preview
@Composable
fun DividerDemo() {
    MyTheme {
        Column(Modifier.padding(8.dp)) {
            Text("Hello")
            Divider(
                thickness = 16.dp,
                color = MaterialTheme.colorScheme.surfaceVariant
            )
            Row {
                Text("World")
                Divider(
                    Modifier.weight(1f),
                    thickness = 8.dp,
                    color = MaterialTheme.colorScheme.primary
                )
                Text("!!!")
            }
        }
    }
}