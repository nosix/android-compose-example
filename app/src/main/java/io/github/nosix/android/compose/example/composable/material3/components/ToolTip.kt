package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.layout.Row
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
fun TooltipBoxDemo() {
    MyTheme {
        Row {

            val scope = rememberCoroutineScope()
            val plainTooltipState = remember { PlainTooltipState() }
            PlainTooltipBox(
                tooltip = {
                    Text(text = "Tooltip")
                },
                tooltipState = plainTooltipState,
                shape = TooltipDefaults.plainTooltipContainerShape,
                containerColor = TooltipDefaults.plainTooltipContainerColor,
                contentColor = TooltipDefaults.plainTooltipContentColor,
            ) {
                Button(
                    onClick = {
                        scope.launch { plainTooltipState.show() }
                    }
                ) {
                    Text(text = "Show plain tooltip")
                }
            }

            val richTooltipState = remember { RichTooltipState() }
            RichTooltipBox(
                text = {
                    Text(text = "Tooltip")
                },
                tooltipState = richTooltipState,
                title = { Text(text = "Title") },
                action = { Text(text = "Action") },
                shape = TooltipDefaults.richTooltipContainerShape,
                colors = TooltipDefaults.richTooltipColors()
            ) {
                Button(
                    onClick = {
                        scope.launch { richTooltipState.show() }
                    }
                ) {
                    Text(text = "Show rich tooltip")
                }
            }
        }
    }
}
