package io.github.nosix.android.compose.example.composable.material3.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import io.github.nosix.android.compose.example.ui.theme.MyTheme

@Preview(showBackground = true)
@Composable
fun TextDemo() {
    MyTheme {
        LazyColumn {
            item {
                Text(text = "color = Color.Red", color = Color.Red)
            }
            item {
                Text(text = "fontSize = 28.sp", fontSize = 28.sp)
            }
            item {
                Text(text = "fontStyle = FontStyle.Italic", fontStyle = FontStyle.Italic)
            }
            item {
                Column {
                    Text(
                        text = "fontWeight = FontWeight.Thin",
                        fontWeight = FontWeight.Thin
                    )
                    Text(
                        text = "fontWeight = FontWeight.ExtraLight",
                        fontWeight = FontWeight.ExtraLight
                    )
                    Text(
                        text = "fontWeight = FontWeight.Light",
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = "fontWeight = FontWeight.Normal",
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = "fontWeight = FontWeight.Medium",
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = "fontWeight = FontWeight.SemiBold",
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "fontWeight = FontWeight.Bold",
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "fontWeight = FontWeight.ExtraBold",
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text = "fontWeight = FontWeight.Black",
                        fontWeight = FontWeight.Black
                    )
                }
            }
            item {
                Column {
                    Text(
                        text = "fontFamily = FontFamily.Default",
                        fontFamily = FontFamily.Default
                    )
                    Text(
                        text = "fontFamily = FontFamily.Serif",
                        fontFamily = FontFamily.Serif
                    )
                    Text(
                        text = "fontFamily = FontFamily.SansSerif",
                        fontFamily = FontFamily.SansSerif
                    )
                    Text(
                        text = "fontFamily = FontFamily.Monospace",
                        fontFamily = FontFamily.Monospace
                    )
                    Text(
                        text = "fontFamily = FontFamily.Cursive",
                        fontFamily = FontFamily.Cursive
                    )
                }
            }
            item {
                Text(text = "letterSpacing = 8.sp", letterSpacing = 8.sp)
            }
            item {
                Column {
                    Text(
                        text = "textDecoration = TextDecoration.LineThrough",
                        textDecoration = TextDecoration.LineThrough
                    )
                    Text(
                        text = "textDecoration = TextDecoration.Underline",
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
            item {
                Column {
                    Text(
                        text = "textAlign = TextAlign.Start",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "textAlign = TextAlign.Center",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "textAlign = TextAlign.End",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End
                    )
                    Text(
                        text = "textAlign = TextAlign.Left",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Left
                    )
                    Text(
                        text = "textAlign = TextAlign.Right",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Right
                    )
                }
            }
            item {
                Text(
                    text = "textAlign = TextAlign.Start サンプル さんぷる Sample",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "textAlign = TextAlign.Justify サンプル さんぷる Sample",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Justify
                )
            }
            item {
                Text(text = "lineHeight\nlineHeight = 8.sp", lineHeight = 8.sp)
            }
            item {
                Column {
                    Text(
                        text = "overflow = TextOverflow.Ellipsis " + "* ".repeat(30),
                        modifier = Modifier.fillMaxWidth(0.8f),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                    Text(
                        text = "overflow = TextOverflow.Visible " + "* ".repeat(30),
                        modifier = Modifier.fillMaxWidth(0.8f),
                        overflow = TextOverflow.Visible,
                        maxLines = 1
                    )
                    Text(
                        text = "overflow = TextOverflow.Clip " + "* ".repeat(30),
                        modifier = Modifier.fillMaxWidth(0.8f),
                        overflow = TextOverflow.Clip,
                        maxLines = 1
                    )
                }
            }
            item {
                Column {
                    Text(text = "softWrap = false " + "* ".repeat(30), softWrap = false)
                    Text(text = "softWrap = true " + "* ".repeat(30), softWrap = true)
                }
            }
            item {
                Text(text = "minLines = 2", minLines = 2)
            }
            item {
                Text(
                    text = "style = MaterialTheme.typography.bodySmall",
                    style = MaterialTheme.typography.bodySmall
                )
            }
            item {
                var text by remember {
                    mutableStateOf("")
                }
                Text(
                    text = text,
                    onTextLayout = {
                        if (text.isBlank()) text = it.toString()
                    },
                )
            }
        }
    }
}