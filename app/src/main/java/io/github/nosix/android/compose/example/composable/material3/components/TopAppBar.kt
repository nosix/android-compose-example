package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.ListItem
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import io.github.nosix.android.compose.example.utils.PrimaryIcon
import io.github.nosix.android.compose.example.utils.SecondaryIcon
import io.github.nosix.android.compose.example.utils.TertiaryIcon

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TopAppBarDemo() {
    MyTheme {
        TopAppBar(
            title = { Text(text = "Title") },
            navigationIcon = { PrimaryIcon() },
            actions = {
                Text(text = "Action")
                Text(text = "Action")
            },
            windowInsets = TopAppBarDefaults.windowInsets,
            colors = TopAppBarDefaults.topAppBarColors(),
            scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun CenterAlignedTopAppBarDemo() {
    MyTheme {
        CenterAlignedTopAppBar(
            title = { Text(text = "Title") },
            navigationIcon = { PrimaryIcon() },
            actions = {
                Text(text = "Action")
                Text(text = "Action")
            },
            windowInsets = TopAppBarDefaults.windowInsets,
            colors = TopAppBarDefaults.topAppBarColors(),
            scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MediumTopAppBarDemo() {
    MyTheme {
        MediumTopAppBar(
            title = { Text(text = "Title") },
            navigationIcon = { PrimaryIcon() },
            actions = {
                Text(text = "Action")
                Text(text = "Action")
            },
            windowInsets = TopAppBarDefaults.windowInsets,
            colors = TopAppBarDefaults.topAppBarColors(),
            scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun LargeTopAppBarDemo() {
    MyTheme {
        LargeTopAppBar(
            title = { Text(text = "Title") },
            navigationIcon = { PrimaryIcon() },
            actions = {
                Text(text = "Action")
                Text(text = "Action")
            },
            windowInsets = TopAppBarDefaults.windowInsets,
            colors = TopAppBarDefaults.topAppBarColors(),
            scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, widthDp = 320, heightDp = 160)
@Composable
fun TopAppBarEnterAlwaysScrollBehaviorDemo() {
    MyTheme {
        Display(scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, widthDp = 320, heightDp = 160)
@Composable
fun TopAppBarExitUntilCollapsedScrollBehaviorDemo() {
    MyTheme {
        Display(scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, widthDp = 320, heightDp = 160)
@Composable
fun TopAppBarPinnedScrollBehaviorDemo() {
    MyTheme {
        Display(scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Display(scrollBehavior: TopAppBarScrollBehavior) {
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text(text = "Title") },
                navigationIcon = { PrimaryIcon() },
                actions = {
                    SecondaryIcon()
                    TertiaryIcon()
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(List(10) { "Item $it" }) {
                ListItem(
                    headlineContent = { Text(text = it) }
                )
            }
        }
    }
}