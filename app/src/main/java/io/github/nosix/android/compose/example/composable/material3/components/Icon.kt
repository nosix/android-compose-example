package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.sharp.Email
import androidx.compose.material.icons.twotone.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@Preview
@Composable
fun IconDemo() {
    MyTheme {
        Row {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = null
            )
            Icon(
                imageVector = Icons.Rounded.Email,
                contentDescription = null
            )
            Icon(
                imageVector = Icons.Sharp.Email,
                contentDescription = null
            )
            Icon(
                imageVector = Icons.TwoTone.Email,
                contentDescription = null
            )
            Icon(
                imageVector = Icons.Outlined.Email,
                contentDescription = null
            )
        }
    }
}