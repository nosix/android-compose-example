package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@Preview(showBackground = true)
@Composable
fun ListItemDemo() {
    MyTheme {
        ListItem(
            headlineContent = {
                Text("HeadLine")
            },
            modifier = Modifier.padding(8.dp),
            overlineContent = {
                Text("OverLine")
            },
            supportingContent = {
                Text("Supporting")
            },
            leadingContent = {
                Text("Leading")
            },
            trailingContent = {
                Text("Trailing")
            },
            colors = ListItemDefaults.colors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            tonalElevation = ListItemDefaults.Elevation,
            shadowElevation = ListItemDefaults.Elevation
        )
    }
}