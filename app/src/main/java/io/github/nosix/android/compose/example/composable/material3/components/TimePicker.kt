package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TimePickerDemo() {
    val timePickerState = rememberTimePickerState()
    MyTheme {
        TimePicker(
            state = timePickerState,
            colors = TimePickerDefaults.colors(),
            layoutType = TimePickerDefaults.layoutType()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TimeInputDemo() {
    val timePickerState = rememberTimePickerState()
    MyTheme {
        TimeInput(
            state = timePickerState,
            colors = TimePickerDefaults.colors()
        )
    }
}