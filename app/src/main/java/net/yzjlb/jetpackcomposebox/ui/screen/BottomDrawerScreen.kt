package net.yzjlb.jetpackcomposebox.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun ButtomDrawerScreen() {
    val scope = rememberCoroutineScope()
    val (gesturesEnabled, toggleGesturesEnabled) = remember { mutableStateOf(true) }
    val drawerState = rememberBottomDrawerState(BottomDrawerValue.Closed)
    ViewScreen(view = {
        Column() {



            BottomDrawer(
                gesturesEnabled = gesturesEnabled,
                drawerState = drawerState,
                drawerContent = {
                    Column(modifier = Modifier.fillMaxWidth().padding(start = 12.dp,end = 12.dp)) {


                    Button(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 16.dp)
                            .fillMaxWidth(),
                        onClick = {
                            scope.launch { drawerState.close() }
                        },
                        content = { Text("关闭抽屉") }
                    )

                    LazyColumn(modifier = Modifier.fillMaxWidth().height(200.dp)) {
                        items(25) {
                            Box(
                                Modifier
                                    .padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 4.dp)
                                    .fillMaxWidth()

                            ) {
                                Text("Item $it")
                            }


                        }
                    }
                    }
                },
                content = {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
//                        val openText =
//                            if (gesturesEnabled) "▲▲▲ Pull up ▲▲▲" else "Click the button!"
                        Text(text = "上滑打开抽屉")
                        Spacer(Modifier.height(20.dp))
                        Button(
                            modifier = Modifier
                                .width(128.dp)
                                .height(40.dp)
                                .background(color = Color.Green),
                            onClick = {
                                scope.launch { drawerState.open() }
                            }) {
                            Text("打开抽屉")
                        }
//
//                        Button(onClick = { scope.launch { drawerState.open() } }) {
//                            Text("Click to open")
//                        }
                    }
                }
            )
        }
    }, title = "BottomDrawer") {

    }
}