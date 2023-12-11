package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TimePickerVerticalDemo() {
    val timePickerState = rememberTimePickerState()
    MyTheme {
        Column {
            TimePicker(
                state = timePickerState,
                colors = TimePickerDefaults.colors(),
                layoutType = TimePickerDefaults.layoutType()
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TimePickerVertical24Demo() {
    val timePickerState = rememberTimePickerState(is24Hour = true)
    MyTheme {
        Column {
            TimePicker(
                state = timePickerState,
                colors = TimePickerDefaults.colors(),
                layoutType = TimePickerDefaults.layoutType()
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, widthDp = 510, heightDp = 280)
@Composable
fun TimePickerHorizontalDemo() {
    val timePickerState = rememberTimePickerState()
    MyTheme {
        Column {
            TimePicker(
                state = timePickerState,
                colors = TimePickerDefaults.colors(),
                layoutType = TimePickerLayoutType.Horizontal
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TimeInputDemo() {
    MyTheme {
        Column {
            TimeInput(
                state = rememberTimePickerState(),
                colors = TimePickerDefaults.colors()
            )
            TimeInput(
                state = rememberTimePickerState(is24Hour = true),
                colors = TimePickerDefaults.colors()
            )
        }
    }
}