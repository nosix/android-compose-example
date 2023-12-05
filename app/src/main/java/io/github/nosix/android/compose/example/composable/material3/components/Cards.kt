package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@Preview(showBackground = true)
@Composable
fun CardDemo() {
    MyTheme {
        Column {
            Card(
                modifier = Modifier.padding(8.dp),
                shape = CardDefaults.shape,
                colors = CardDefaults.cardColors(),
                elevation = CardDefaults.cardElevation(),
                border = null
            ) {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
                Text("Card")
            }

            ElevatedCard(Modifier.padding(8.dp)) {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
                Text("ElevatedCard")
            }

            OutlinedCard(Modifier.padding(8.dp)) {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
                Text("OutlinedCard")
            }
        }
    }
}
