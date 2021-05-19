package net.yzjlb.jetpackcomposebox.ui.screen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign


class State(var count: Int = 0)

@Composable
fun TextFieldScreen() {
    var text: MutableState<String> = remember { mutableStateOf("这是一段文本") }
    var align: MutableState<TextAlign> = remember { mutableStateOf(TextAlign.Start) }
    var textColor: MutableState<Color> = remember { mutableStateOf(Color.Black) }
    var backgroundColor: MutableState<Color> = remember { mutableStateOf(Color.Transparent) }
    var cursorColor: MutableState<Color> = remember { mutableStateOf(Color.Blue)}
    var focusedIndicatorColor: MutableState<Color> = remember { mutableStateOf(Color.Blue)}
    var unfocusedIndicatorColor: MutableState<Color> = remember { mutableStateOf(Color.Blue)}

    ViewScreen(view = {
        TextField(value = text.value,modifier = Modifier.fillMaxWidth(), onValueChange = {
                text.value = it
        },colors = TextFieldDefaults.textFieldColors(textColor = textColor.value,
            backgroundColor = backgroundColor.value,
            cursorColor = cursorColor.value,
            focusedIndicatorColor = focusedIndicatorColor.value,
            unfocusedIndicatorColor = unfocusedIndicatorColor.value,
        ))
    },title = "TextField") {
        Column() {
            Text(text = "对齐方式")
            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                ButtonItem(text = "Start") {
                    align.value = TextAlign.Start
                }

                ButtonItem(text = "End") {
                    align.value = TextAlign.End
                }

                ButtonItem(text = "Left") {
                    align.value = TextAlign.Left
                }

                ButtonItem(text = "Right") {
                    align.value = TextAlign.Right
                }
                ButtonItem(text = "Center") {
                    align.value = TextAlign.Center
                }
            }
            Text(text = "文字颜色")
            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                ButtonItem(text = "绿色") {
                    textColor.value = Color.Green
                }

                ButtonItem(text = "红色") {
                    textColor.value = Color.Red
                }

                ButtonItem(text = "白色") {
                    textColor.value = Color.White
                }

                ButtonItem(text = "黑色") {
                    textColor.value = Color.Black
                }

            }
            Text(text = "文字背景")
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

            Text(text = "不重要指针颜色")
            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                ButtonItem(text = "无") {
                    unfocusedIndicatorColor.value = Color.Transparent
                }

                ButtonItem(text = "灰色") {
                    unfocusedIndicatorColor.value = Color.Gray
                }

                ButtonItem(text = "蓝色") {
                    unfocusedIndicatorColor.value = Color.Blue
                }

                ButtonItem(text = "黄色") {
                    unfocusedIndicatorColor.value = Color.Yellow
                }
            }
            Text(text = "主要指针颜色")
            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                ButtonItem(text = "无") {
                    focusedIndicatorColor.value = Color.Transparent
                }

                ButtonItem(text = "灰色") {
                    focusedIndicatorColor.value = Color.Gray
                }

                ButtonItem(text = "蓝色") {
                    focusedIndicatorColor.value = Color.Blue
                }

                ButtonItem(text = "黄色") {
                    focusedIndicatorColor.value = Color.Yellow
                }
            }
        }
    }
}