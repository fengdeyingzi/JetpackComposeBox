package net.yzjlb.jetpackcomposebox.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CardScreen() {

    var shape: MutableState<Shape> = remember {
        mutableStateOf(RoundedCornerShape(4.dp))
    };
    var backgroundColor: MutableState<Color> = remember { mutableStateOf(Color.White) }
    var contentColor: MutableState<Color>  = remember {
        mutableStateOf(Color.White)
    }
    var border: MutableState<BorderStroke?> = remember {
        mutableStateOf(null)
    }
    var elevation:MutableState<Dp> = remember {
        mutableStateOf(1.dp)
    }
    ViewScreen(view = {
        Card(modifier = Modifier.fillMaxWidth().height(100.dp).padding(16.dp), shape = shape.value, backgroundColor = backgroundColor.value, contentColor = contentColor.value,border = border.value, elevation = elevation.value) {

        }
    }, title = "Card") {
        Text(text = "背景色")
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            ButtonItem(text = "无") {
                backgroundColor.value = Color.Transparent
            }

            ButtonItem(text = "灰色") {
                backgroundColor.value = Color.Gray
            }

            ButtonItem(text = "蓝色") {
                backgroundColor.value = Color.Blue
            }

            ButtonItem(text = "黄色") {
                backgroundColor.value = Color.Yellow
            }
        }
        Text(text = "内容颜色")
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            ButtonItem(text = "无") {
                contentColor.value = Color.Transparent
            }

            ButtonItem(text = "灰色") {
                contentColor.value = Color.Gray
            }

            ButtonItem(text = "蓝色") {
                contentColor.value = Color.Blue
            }

            ButtonItem(text = "黄色") {
                contentColor.value = Color.Yellow
            }
            ButtonItem(text = "白色") {
                contentColor.value = Color.White
            }
        }
    }
}