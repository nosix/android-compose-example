package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PlainTooltipBox
import androidx.compose.material3.PlainTooltipState
import androidx.compose.material3.RichTooltipBox
import androidx.compose.material3.RichTooltipState
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PlainTooltipBoxDemo() {
    MyTheme {
        val scope = rememberCoroutineScope()
        val tooltipState = remember { PlainTooltipState() }
        PlainTooltipBox(
            tooltip = {
                Text(text = "Tooltip")
            },
            tooltipState = tooltipState,
            shape = TooltipDefaults.plainTooltipContainerShape,
            containerColor = TooltipDefaults.plainTooltipContainerColor,
            contentColor = TooltipDefaults.plainTooltipContentColor,
        ) {
            Button(
                onClick = {
                    scope.launch { tooltipState.show() }
                }
            ) {
                Text(text = "Show tooltip")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun RichTooltipBoxDemo() {
    MyTheme {
        val scope = rememberCoroutineScope()
        val tooltipState = remember { RichTooltipState() }
        RichTooltipBox(
            text = {
                Text(text = "Tooltip")
            },
            tooltipState = tooltipState,
            title = { Text(text = "Title") },
            action = { Text(text = "Action") },
            shape = TooltipDefaults.richTooltipContainerShape,
            colors = TooltipDefaults.richTooltipColors()
        ) {
            Button(
                onClick = {
                    scope.launch { tooltipState.show() }
                }
            ) {
                Text(text = "Show tooltip")
            }
        }
    }
}