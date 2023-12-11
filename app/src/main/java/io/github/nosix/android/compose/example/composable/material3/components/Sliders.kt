package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SliderDemo() {
    MyTheme {
        Column {
            var value by remember { mutableFloatStateOf(5f) }
            var thumbColor by remember { mutableStateOf(Color.Black) }
            Slider(
                value = value,
                onValueChange = { value = it },
                enabled = true,
                valueRange = 0f..10f,
                steps = 3,
                onValueChangeFinished = {
                    thumbColor = if (thumbColor == Color.Black) Color.Gray else Color.Black
                },
                colors = SliderDefaults.colors(
                    thumbColor = thumbColor
                ),
                interactionSource = remember { MutableInteractionSource() }
            )

            val interactionSource = remember { MutableInteractionSource() }
            Slider(
                value = 0.5f,
                onValueChange = {},
                enabled = true,
                onValueChangeFinished = { },
                colors = SliderDefaults.colors(),
                interactionSource = interactionSource,
                steps = 0,
                thumb = {
                    SliderDefaults.Thumb(
                        interactionSource = interactionSource,
                        colors = SliderDefaults.colors(),
                        enabled = false,
                        thumbSize = DpSize(20.dp, 20.dp)
                    )
                },
                track = { positions ->
                    SliderDefaults.Track(
                        sliderPositions = positions,
                        colors = SliderDefaults.colors(),
                        enabled = false
                    )
                },
                valueRange = 0f..1f
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun RangeSliderDemo() {
    MyTheme {
        Column {
            var value by remember { mutableStateOf(0.2f..0.8f) }
            var thumbColor by remember { mutableStateOf(Color.Black) }
            RangeSlider(
                value = value,
                onValueChange = { value = it },
                enabled = true,
                valueRange = 0f..1f,
                steps = 4,
                onValueChangeFinished = {
                    thumbColor = if (thumbColor == Color.Black) Color.Gray else Color.Black
                },
                colors = SliderDefaults.colors(
                    thumbColor = thumbColor
                )
            )

            val interactionSource = remember { MutableInteractionSource() }
            RangeSlider(
                value = 0.2f..0.8f,
                onValueChange = {},
                enabled = true,
                valueRange = 0f..1f,
                onValueChangeFinished = { },
                colors = SliderDefaults.colors(),
                startInteractionSource = interactionSource,
                endInteractionSource = interactionSource,
                startThumb = {
                    SliderDefaults.Thumb(
                        interactionSource = interactionSource,
                        colors = SliderDefaults.colors(),
                        enabled = false,
                        thumbSize = DpSize(20.dp, 20.dp)
                    )
                },
                endThumb = {
                    SliderDefaults.Thumb(
                        interactionSource = interactionSource,
                        colors = SliderDefaults.colors(),
                        enabled = false,
                        thumbSize = DpSize(20.dp, 20.dp)
                    )
                },
                track = { positions ->
                    SliderDefaults.Track(
                        sliderPositions = positions,
                        colors = SliderDefaults.colors(),
                        enabled = false
                    )
                },
                steps = 0,
            )
        }
    }
}