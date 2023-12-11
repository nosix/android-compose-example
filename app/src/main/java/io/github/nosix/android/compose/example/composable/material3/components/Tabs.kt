package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Divider
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import io.github.nosix.android.compose.example.utils.PrimaryIcon
import io.github.nosix.android.compose.example.utils.SecondaryIcon
import io.github.nosix.android.compose.example.utils.animateDpValue

@Preview(showBackground = true)
@Composable
fun TabDemo() {
    MyTheme {
        var selectedTabIndex by remember { mutableIntStateOf(0) }
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = TabRowDefaults.containerColor,
            contentColor = TabRowDefaults.contentColor,
            indicator = { tabPositions ->
                if (selectedTabIndex < tabPositions.size) {
                    TabRowDefaults.Indicator(
                        Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
                    )
                }
            },
            divider = {
                Divider()
            }
        ) {
            Tab(
                selected = selectedTabIndex == 0,
                onClick = { selectedTabIndex = 0 },
                enabled = true,
                selectedContentColor = LocalContentColor.current,
                unselectedContentColor = LocalContentColor.current,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                Text(text = "Content")
            }
            Tab(
                selected = selectedTabIndex == 1,
                onClick = { selectedTabIndex = 1 },
                enabled = true,
                text = { Text(text = "Text") },
                icon = { PrimaryIcon() },
                selectedContentColor = LocalContentColor.current,
                unselectedContentColor = LocalContentColor.current,
                interactionSource = remember { MutableInteractionSource() }
            )
            LeadingIconTab(
                selected = selectedTabIndex == 2,
                onClick = { selectedTabIndex = 2 },
                text = { Text(text = "Text") },
                icon = { SecondaryIcon() },
                enabled = false,
                selectedContentColor = LocalContentColor.current,
                unselectedContentColor = LocalContentColor.current,
                interactionSource = remember { MutableInteractionSource() }
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 200)
@Composable
fun ScrollableTabRowDemo() {
    val animateEdgePadding = false

    MyTheme {
        var selectedTabIndex by remember { mutableIntStateOf(0) }
        val infiniteTransition = rememberInfiniteTransition(label = "")
        val dpValue by infiniteTransition.animateDpValue()

        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = TabRowDefaults.containerColor,
            contentColor = TabRowDefaults.contentColor,
            edgePadding = if (animateEdgePadding) dpValue else 0.dp,
            indicator = { tabPositions ->
                if (selectedTabIndex < tabPositions.size) {
                    TabRowDefaults.Indicator(
                        Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
                    )
                }
            },
            divider = {
                Divider()
            }
        ) {
            Tab(
                selected = selectedTabIndex == 0,
                onClick = { selectedTabIndex = 0 },
                enabled = true,
                selectedContentColor = LocalContentColor.current,
                unselectedContentColor = LocalContentColor.current,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                Text(text = "Content")
            }
            Tab(
                selected = selectedTabIndex == 1,
                onClick = { selectedTabIndex = 1 },
                enabled = false,
                text = { Text(text = "Text") },
                icon = { PrimaryIcon() },
                selectedContentColor = LocalContentColor.current,
                unselectedContentColor = LocalContentColor.current,
                interactionSource = remember { MutableInteractionSource() }
            )
            LeadingIconTab(
                selected = selectedTabIndex == 2,
                onClick = { selectedTabIndex = 2 },
                text = { Text(text = "Text") },
                icon = { SecondaryIcon() },
                enabled = true,
                selectedContentColor = LocalContentColor.current,
                unselectedContentColor = LocalContentColor.current,
                interactionSource = remember { MutableInteractionSource() }
            )
        }
    }
}