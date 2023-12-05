package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@Preview(showBackground = true)
@Composable
fun TabDemo() {
    MyTheme {
        val selectedTabIndex by remember { mutableIntStateOf(0) }
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
                selected = true,
                onClick = {},
                enabled = true,
                selectedContentColor = LocalContentColor.current,
                unselectedContentColor = LocalContentColor.current,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                Text(text = "Content")
            }
            Tab(
                selected = false,
                onClick = {},
                enabled = false,
                text = { Text(text = "Text") },
                icon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
                selectedContentColor = LocalContentColor.current,
                unselectedContentColor = LocalContentColor.current,
                interactionSource = remember { MutableInteractionSource() }
            )
            LeadingIconTab(
                selected = true,
                onClick = {},
                text = { Text(text = "Text") },
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
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
    MyTheme {
        val selectedTabIndex by remember { mutableIntStateOf(0) }
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = TabRowDefaults.containerColor,
            contentColor = TabRowDefaults.contentColor,
            edgePadding = 0.dp,
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
                selected = true,
                onClick = {},
                enabled = true,
                selectedContentColor = LocalContentColor.current,
                unselectedContentColor = LocalContentColor.current,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                Text(text = "Content")
            }
            Tab(
                selected = false,
                onClick = {},
                enabled = false,
                text = { Text(text = "Text") },
                icon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
                selectedContentColor = LocalContentColor.current,
                unselectedContentColor = LocalContentColor.current,
                interactionSource = remember { MutableInteractionSource() }
            )
            LeadingIconTab(
                selected = true,
                onClick = {},
                text = { Text(text = "Text") },
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                enabled = false,
                selectedContentColor = LocalContentColor.current,
                unselectedContentColor = LocalContentColor.current,
                interactionSource = remember { MutableInteractionSource() }
            )
        }
    }
}