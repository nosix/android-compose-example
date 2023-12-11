package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import io.github.nosix.android.compose.example.utils.animateColorValue
import io.github.nosix.android.compose.example.utils.animateDpValue

@Preview(showBackground = true)
@Composable
fun DividerDemo() {
    val animateThickness = false
    val animateColor = false

    MyTheme {
        Column(Modifier.padding(8.dp)) {
            val infiniteTransition = rememberInfiniteTransition(label = "")
            val dpValue by infiniteTransition.animateDpValue()
            val color by infiniteTransition.animateColorValue(
                enabled = animateColor,
                initialValue = DividerDefaults.color
            )

            Text("Hello")
            Divider(
                modifier = Modifier.padding(8.dp),
                thickness = if (animateThickness) dpValue else DividerDefaults.Thickness,
                color = color
            )
            Row {
                Text("World")
                Divider(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    thickness = 8.dp,
                    color = MaterialTheme.colorScheme.primary
                )
                Text("!!!")
            }
        }
    }
}