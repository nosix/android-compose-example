package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgeDefaults
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme
import io.github.nosix.android.compose.example.utils.PrimaryIcon
import io.github.nosix.android.compose.example.utils.animateColorValue

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, widthDp = 100, heightDp = 100)
@Composable
fun BadgeDemo() {
    val animateContainerColor = false
    val animateContentColor = false

    Display {
        val infiniteTransition = rememberInfiniteTransition(label = "")
        val containerColor by infiniteTransition.animateColorValue(
            enabled = animateContainerColor,
            initialValue = BadgeDefaults.containerColor
        )
        val contentColor by infiniteTransition.animateColorValue(
            enabled = animateContentColor,
            initialValue = contentColorFor(BadgeDefaults.containerColor)
        )

        Badge(
            containerColor = containerColor,
            contentColor = contentColor
        ) {
            Text(text = "10")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, widthDp = 100, heightDp = 100)
@Composable
fun BadgeBoxDemo() {
    Display {
        BadgedBox(
            badge = {
                Badge {
                    Text(text = "10")
                }
            },
        ) {
            PrimaryIcon()
        }
    }
}

@Composable
fun Display(content: @Composable () -> Unit) {
    MyTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}
