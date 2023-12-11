package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import io.github.nosix.android.compose.example.utils.PrimaryIcon
import io.github.nosix.android.compose.example.utils.SecondaryIcon
import io.github.nosix.android.compose.example.utils.animateDpValue
import io.github.nosix.android.compose.example.utils.toWindowInsets

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, widthDp = 320, heightDp = 160)
@Composable
fun SearchBarDemo() {
    val animateWindowInsets = true

    MyTheme {
        val infiniteTransition = rememberInfiniteTransition(label = "")
        val dpValue by infiniteTransition.animateDpValue()

        var query by remember { mutableStateOf("") }
        var active by remember { mutableStateOf(true) }

        val activeText = if (active) "active" else ""

        SearchBar(
            query = query,
            onQueryChange = { query = it },
            onSearch = { active = false },
            active = active,
            onActiveChange = { active = it },
            enabled = true,
            placeholder = { Text(text = "Placeholder $activeText") },
            leadingIcon = { PrimaryIcon() },
            trailingIcon = { SecondaryIcon() },
            shape = SearchBarDefaults.inputFieldShape,
            colors = SearchBarDefaults.colors(),
            tonalElevation = SearchBarDefaults.Elevation,
            windowInsets = if (animateWindowInsets) dpValue.toWindowInsets() else SearchBarDefaults.windowInsets,
            interactionSource = remember { MutableInteractionSource() },
        ) {
            Text(text = "Content")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, widthDp = 320, heightDp = 160)
@Composable
fun DockedSearchBarDemo() {
    MyTheme {
        var query by remember { mutableStateOf("") }
        var active by remember { mutableStateOf(true) }

        DockedSearchBar(
            query = query,
            onQueryChange = { query = it },
            onSearch = { active = false },
            active = active,
            onActiveChange = { active = it },
            enabled = true,
            placeholder = { Text(text = "Placeholder") },
            leadingIcon = { PrimaryIcon() },
            trailingIcon = { SecondaryIcon() },
            shape = SearchBarDefaults.dockedShape,
            colors = SearchBarDefaults.colors(),
            tonalElevation = SearchBarDefaults.Elevation,
            interactionSource = remember { MutableInteractionSource() },
        ) {
            Text("Content")
        }
    }
}