package net.yzjlb.jetpackcomposebox.ui.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp





@Composable
fun TextScreen() {
    var text: MutableState<String> = remember {mutableStateOf("这是一段文本")}
    var align: MutableState<TextAlign> = remember {mutableStateOf(TextAlign.Start)}
    var textColor: MutableState<Color> = remember {mutableStateOf(Color.Black)}
    var backgroundColor:MutableState<Color> = remember {mutableStateOf(Color.Transparent)}
    Column() {
        ViewScreen(
            view = {
                Column() {
                    Text(
                        text.value,
                        color = textColor.value,
                        textAlign = align.value,
                        modifier = Modifier
                            .background(backgroundColor.value)
                            .fillMaxWidth()
                            .fillMaxHeight()
                    )
                }
            },
            title="Text",
            content = {
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
//                    Row() {
//                        Button(onClick = {
//
//                        }) {
//                            Text(text = "从左到右")
//                        }
//                        Button(onClick = {
//
//                        }) {
//                            Text(text = "从右到左")
//                        }
//
//                    }
                }
            })
    }


}

@Composable
fun ButtonItem(text: String, onClick: () -> Unit) {
    Box(modifier = Modifier.padding(8.dp)) {
        Text(
            text = text, modifier = Modifier
                .clickable(onClick = onClick)
                .padding(start = 8.dp, end = 8.dp)
                .background(color = Color.LightGray)
        )
    }
}