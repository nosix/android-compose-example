package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import io.github.nosix.android.compose.example.utils.PrimaryIcon

@Preview(showBackground = true)
@Composable
fun FloatingActionButtonDemo() {
    MyTheme {
        Column {
            Text("FloatingActionButton")
            FloatingActionButton(
                onClick = {},
                modifier = Modifier.padding(8.dp),
                shape = FloatingActionButtonDefaults.shape,
                containerColor = FloatingActionButtonDefaults.containerColor,
                contentColor = contentColorFor(FloatingActionButtonDefaults.containerColor),
                elevation = FloatingActionButtonDefaults.elevation(),
                interactionSource = remember { MutableInteractionSource() }
            ) {
                PrimaryIcon()
            }

            Text("SmallFloatingActionButton")
            SmallFloatingActionButton(
                onClick = {},
                modifier = Modifier.padding(8.dp),
                shape = FloatingActionButtonDefaults.smallShape,
                containerColor = FloatingActionButtonDefaults.containerColor,
                contentColor = contentColorFor(FloatingActionButtonDefaults.containerColor),
                elevation = FloatingActionButtonDefaults.elevation(),
                interactionSource = remember { MutableInteractionSource() }
            ) {
                PrimaryIcon()
            }

            Text("LargeFloatingActionButton")
            LargeFloatingActionButton(
                onClick = {},
                modifier = Modifier.padding(8.dp),
                shape = FloatingActionButtonDefaults.largeShape,
                containerColor = FloatingActionButtonDefaults.containerColor,
                contentColor = contentColorFor(FloatingActionButtonDefaults.containerColor),
                elevation = FloatingActionButtonDefaults.elevation(),
                interactionSource = remember { MutableInteractionSource() }
            ) {
                PrimaryIcon()
            }

            Text("ExtendedFloatingActionButton")
            ExtendedFloatingActionButton(
                onClick = {},
                modifier = Modifier.padding(8.dp),
                shape = FloatingActionButtonDefaults.extendedFabShape,
                containerColor = FloatingActionButtonDefaults.containerColor,
                contentColor = contentColorFor(FloatingActionButtonDefaults.containerColor),
                elevation = FloatingActionButtonDefaults.elevation(),
                interactionSource = remember { MutableInteractionSource() }
            ) {
                PrimaryIcon()
            }
        }
    }
}
