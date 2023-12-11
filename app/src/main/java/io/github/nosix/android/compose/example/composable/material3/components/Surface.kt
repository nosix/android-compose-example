package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import io.github.nosix.android.compose.example.utils.animateColorValue
import io.github.nosix.android.compose.example.utils.animateDpValue

@Preview(showBackground = true, widthDp = 320, heightDp = 160)
@Composable
fun SurfaceDemo() {
    val animateColor = false
    val animateContentColor = false
    val animateTonalElevation = false
    val animateShadowElevation = false
    val animateBorderColor = false

    MyTheme {
        val infiniteTransition = rememberInfiniteTransition(label = "")
        val color by infiniteTransition.animateColorValue(
            enabled = animateColor,
            initialValue = MaterialTheme.colorScheme.surface
        )
        val contentColor by infiniteTransition.animateColorValue(
            enabled = animateContentColor,
            initialValue = contentColorFor(MaterialTheme.colorScheme.surface)
        )
        val borderColor by infiniteTransition.animateColorValue(
            enabled = animateBorderColor,
            initialValue = MaterialTheme.colorScheme.primary
        )
        val dpValue by infiniteTransition.animateDpValue()

        Surface(
            modifier = Modifier.padding(8.dp),
            shape = RectangleShape,
            color = color,
            contentColor = contentColor,
            tonalElevation = if (animateTonalElevation) dpValue else 0.dp,
            shadowElevation = if (animateShadowElevation) dpValue else 0.dp,
            border = BorderStroke(2.dp, color = borderColor),
        ) {
            Text(text = "Content")
        }
    }
}