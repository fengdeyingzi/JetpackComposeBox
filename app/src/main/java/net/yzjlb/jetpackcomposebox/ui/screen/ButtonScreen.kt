package net.yzjlb.jetpackcomposebox.ui.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
fun ButtonScreen() {
    var text: MutableState<String> = remember {mutableStateOf("这是按钮")}
    var align: MutableState<TextAlign> = remember {mutableStateOf(TextAlign.Start)}
    var textColor: MutableState<Color> = remember {mutableStateOf(Color.Black)}
    var backgroundColor:MutableState<Color> = remember {mutableStateOf(Color.Blue)}
    var contentColor:MutableState<Color> = remember {mutableStateOf(Color.Black)}
    var disabledBackgroundColor:MutableState<Color> = remember {mutableStateOf(Color.Gray)}
    var disabledContentColor:MutableState<Color> = remember {mutableStateOf(Color.LightGray)}
    var isDisable:MutableState<Boolean> = remember {mutableStateOf(false)}
    Column() {
        ViewScreen(
            view = {
                Column() {
                    Button(
                        onClick = {

                        },
                        enabled = !isDisable.value,
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = backgroundColor.value,
                            contentColor = contentColor.value,
                            disabledBackgroundColor = disabledBackgroundColor.value,
                            disabledContentColor = disabledContentColor.value
                        )
//                        text.value,
//                        color = textColor.value,
//                        textAlign = align.value,
//                        modifier = Modifier
//                            .background(backgroundColor.value)
//                            .fillMaxWidth()
//                            .fillMaxHeight()
                    ){
                        Text(text.value)
                    }
                }
            },
            title="Button",
            content = {
                Column() {
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
                    Text(text = "禁用背景色")
                    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                        ButtonItem(text = "无") {
                            disabledBackgroundColor.value = Color.Transparent
                        }

                        ButtonItem(text = "灰色") {
                            disabledBackgroundColor.value = Color.Gray
                        }

                        ButtonItem(text = "蓝色") {
                            disabledBackgroundColor.value = Color.Blue
                        }

                        ButtonItem(text = "黄色") {
                            disabledBackgroundColor.value = Color.Yellow
                        }
                    }
                    Text(text = "禁用内容颜色")
                    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                        ButtonItem(text = "无") {
                            disabledContentColor.value = Color.Transparent
                        }

                        ButtonItem(text = "灰色") {
                            disabledContentColor.value = Color.Gray
                        }

                        ButtonItem(text = "蓝色") {
                            disabledContentColor.value = Color.Blue
                        }

                        ButtonItem(text = "黄色") {
                            disabledContentColor.value = Color.Yellow
                        }
                    }
                    Row() {
                        Text("是否禁用")
                        Switch(checked = isDisable.value,onCheckedChange = {
                            isDisable.value = it
                        })
                    }

                }
            })
    }


}

