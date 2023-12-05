package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalLayoutApi::class)
@Preview(showBackground = true)
@Composable
fun ScaffoldDemo() {
    MyTheme {
        val scope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }
        Scaffold(
            topBar = { Text(text = "TopBar") },
            bottomBar = { Text(text = "BottomBar") },
            snackbarHost = {
                SnackbarHost(snackbarHostState) {
                    Snackbar {
                        Text(text = "SnackbarHost")
                    }
                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("Snackbar")
                        }
                    }
                ) {
                    Text(text = "FAB")
                }
            },
            floatingActionButtonPosition = FabPosition.End,
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = contentColorFor(MaterialTheme.colorScheme.background),
            contentWindowInsets = ScaffoldDefaults.contentWindowInsets,
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier.consumeWindowInsets(innerPadding),
                contentPadding = innerPadding
            ) {
                item { Text(text = "Content") }
            }
        }
    }
}
