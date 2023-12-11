package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import io.github.nosix.android.compose.example.utils.animateFloatValue

@Preview(showBackground = true)
@Composable
fun LinearProgressIndicatorDemo() {
    val animateProgress = true

    MyTheme {
        Column {
            val infiniteTransition = rememberInfiniteTransition(label = "")
            val progress by infiniteTransition.animateFloatValue(
                enabled = animateProgress,
                initialValue = 0.5f
            )

            LinearProgressIndicator(
                progress = 0.5f,
                modifier = Modifier.padding(8.dp),
                color = ProgressIndicatorDefaults.linearColor,
                trackColor = ProgressIndicatorDefaults.linearTrackColor,
                strokeCap = ProgressIndicatorDefaults.LinearStrokeCap
            )
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .padding(8.dp)
                    .height(8.dp),
                strokeCap = StrokeCap.Butt
            )
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .padding(8.dp)
                    .height(8.dp),
                strokeCap = StrokeCap.Round
            )
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .padding(8.dp)
                    .height(8.dp),
                strokeCap = StrokeCap.Square
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CircularProgressIndicatorDemo() {
    val animateProgress = true

    MyTheme {
        Row {
            val infiniteTransition = rememberInfiniteTransition(label = "")
            val progress by infiniteTransition.animateFloatValue(
                enabled = animateProgress,
                initialValue = 0.5f
            )

            CircularProgressIndicator(
                progress = 0.5f,
                strokeWidth = ProgressIndicatorDefaults.CircularStrokeWidth,
                color = ProgressIndicatorDefaults.circularColor,
                trackColor = ProgressIndicatorDefaults.circularTrackColor,
                strokeCap = ProgressIndicatorDefaults.CircularIndeterminateStrokeCap
            )
            CircularProgressIndicator(
                progress = progress,
                strokeWidth = 8.dp,
                strokeCap = StrokeCap.Square
            )
            CircularProgressIndicator(
                progress = progress,
                strokeWidth = 8.dp,
                strokeCap = StrokeCap.Butt
            )
            CircularProgressIndicator(
                progress = progress,
                strokeWidth = 8.dp,
                strokeCap = StrokeCap.Round
            )
        }
    }
}