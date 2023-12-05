package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@Preview(showBackground = true)
@Composable
fun LinearProgressIndicatorDemo() {
    MyTheme {
        LinearProgressIndicator(
            progress = 0.5f,
            color = ProgressIndicatorDefaults.linearColor,
            trackColor = ProgressIndicatorDefaults.linearTrackColor,
            strokeCap = ProgressIndicatorDefaults.LinearStrokeCap
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CircularProgressIndicatorDemo() {
    MyTheme {
        CircularProgressIndicator(
            progress = 0.5f,
            strokeWidth = ProgressIndicatorDefaults.CircularStrokeWidth,
            color = ProgressIndicatorDefaults.circularColor,
            trackColor = ProgressIndicatorDefaults.circularTrackColor,
            strokeCap = ProgressIndicatorDefaults.CircularIndeterminateStrokeCap
        )
    }
}