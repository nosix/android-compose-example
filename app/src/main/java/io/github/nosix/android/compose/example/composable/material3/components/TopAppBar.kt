package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TopAppBarDemo() {
    MyTheme {
        TopAppBar(
            title = { Text(text = "Title") },
            navigationIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
            },
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
@Preview
@Composable
fun CenterAlignedTopAppBarDemo() {
    MyTheme {
        CenterAlignedTopAppBar(
            title = { Text(text = "Title") },
            navigationIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
            },
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
@Preview
@Composable
fun MediumTopAppBarDemo() {
    MyTheme {
        MediumTopAppBar(
            title = { Text(text = "Title") },
            navigationIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
            },
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
@Preview
@Composable
fun LargeTopAppBarDemo() {
    MyTheme {
        LargeTopAppBar(
            title = { Text(text = "Title") },
            navigationIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
            },
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