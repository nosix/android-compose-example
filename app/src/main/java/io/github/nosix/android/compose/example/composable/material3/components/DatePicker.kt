package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerFormatter
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DateRangePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import java.time.Instant
import java.time.temporal.ChronoUnit

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DatePickerDemo() {
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = Instant.now().toEpochMilli()
    )
    val datePickerFormatter = remember { DatePickerFormatter() }

    MyTheme {
        DatePicker(
            state = datePickerState,
            dateFormatter = datePickerFormatter,
            dateValidator = { it > Instant.now().toEpochMilli() },
            title = {
                Column {
                    Text("Title")
                    DatePickerDefaults.DatePickerTitle(
                        state = datePickerState
                    )
                }
            },
            headline = {
                Column {
                    Text("Headline ")
                    DatePickerDefaults.DatePickerHeadline(
                        state = datePickerState,
                        dateFormatter = datePickerFormatter
                    )
                }
            },
            showModeToggle = true,
            colors = DatePickerDefaults.colors()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DateRangePickerDemo() {
    val dateRangePickerState = rememberDateRangePickerState(
        initialSelectedStartDateMillis = Instant.now().toEpochMilli(),
        initialSelectedEndDateMillis = Instant.now().plus(10, ChronoUnit.DAYS).toEpochMilli(),
    )
    val datePickerFormatter = remember { DatePickerFormatter() }
    MyTheme {
        DateRangePicker(
            state = dateRangePickerState,
            dateFormatter = datePickerFormatter,
            dateValidator = { it < Instant.now().plus(20, ChronoUnit.DAYS).toEpochMilli() },
            title = {
                Column {
                    Text("Title")
                    DateRangePickerDefaults.DateRangePickerTitle(
                        state = dateRangePickerState
                    )
                }
            },
            headline = {
                Column {
                    Text("Headline ")
                    DateRangePickerDefaults.DateRangePickerHeadline(
                        state = dateRangePickerState,
                        dateFormatter = datePickerFormatter
                    )
                }
            },
            showModeToggle = true,
            colors = DatePickerDefaults.colors()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun DatePickerDialogDemo() {
    MyTheme {
        var isDismissed by remember { mutableStateOf(false) }
        DatePickerDialog(
            onDismissRequest = {
                isDismissed = true
            },
            confirmButton = {
                IconButton(
                    imageVector = Icons.Default.Check,
                    onClick = {}
                )
            },
            dismissButton = {
                IconButton(
                    imageVector = Icons.Default.Close,
                    onClick = {}
                )
            },
            shape = DatePickerDefaults.shape,
            tonalElevation = DatePickerDefaults.TonalElevation,
            colors = DatePickerDefaults.colors(),
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            ),
        ) {
            Text(text = "DatePickerDialog")
            Text(text = if (isDismissed) "dismissed" else "")
            Button(onClick = { isDismissed = false }) {
                Text(text = "Clear")
            }
        }
    }
}
