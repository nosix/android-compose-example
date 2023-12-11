package io.github.nosix.android.compose.example.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun PrimaryIcon() {
    Icon(imageVector = Icons.Default.Home, contentDescription = "PrimaryIcon")
}

@Composable
fun SecondaryIcon() {
    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "SecondaryIcon")
}

@Composable
fun TertiaryIcon() {
    Icon(imageVector = Icons.Default.Settings, contentDescription = "TertiaryIcon")
}
