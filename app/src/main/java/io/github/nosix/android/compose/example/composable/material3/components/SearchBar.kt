package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SearchBarDemo() {
    MyTheme {
        SearchBar(
            query = "",
            onQueryChange = {},
            onSearch = {},
            active = true,
            onActiveChange = {},
            enabled = true,
            placeholder = {
                Text(text = "Placeholder")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
            },
            trailingIcon = {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
            },
            shape = SearchBarDefaults.inputFieldShape,
            colors = SearchBarDefaults.colors(),
            tonalElevation = SearchBarDefaults.Elevation,
            windowInsets = SearchBarDefaults.windowInsets,
            interactionSource = remember { MutableInteractionSource() },
        ) {
            Text("Content")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DockedSearchBarDemo() {
    MyTheme {
        DockedSearchBar(
            query = "",
            onQueryChange = {},
            onSearch = {},
            active = true,
            onActiveChange = {},
            enabled = true,
            placeholder = {
                Text(text = "Placeholder")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
            },
            trailingIcon = {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
            },
            shape = SearchBarDefaults.dockedShape,
            colors = SearchBarDefaults.colors(),
            tonalElevation = SearchBarDefaults.Elevation,
            interactionSource = remember { MutableInteractionSource() },
        ) {
            Text("Content")
        }
    }
}