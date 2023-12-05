package io.github.nosix.android.compose.example.utils

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun InfiniteTransition.animateDpValue(
    initialValue: Dp = 0.dp,
    targetValue: Dp = 64.dp,
    durationMillis: Int = 1000,
    easing: Easing = LinearEasing,
    repeatMode: RepeatMode = RepeatMode.Reverse,
    label: String = ""
): State<Dp> = this.animateValue(
    initialValue = initialValue,
    targetValue = targetValue,
    typeConverter = Dp.VectorConverter,
    animationSpec = infiniteRepeatable(
        animation = tween(durationMillis = durationMillis, easing = easing),
        repeatMode = repeatMode
    ),
    label = label
)

fun Dp.toPaddingValues() = PaddingValues(this)
fun Dp.toWindowInsets() = WindowInsets(this, this, this, this)