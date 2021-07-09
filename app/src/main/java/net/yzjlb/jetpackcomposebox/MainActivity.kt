package net.yzjlb.jetpackcomposebox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import net.yzjlb.jetpackcomposebox.ui.screen.*
import net.yzjlb.jetpackcomposebox.ui.theme.JetpackComposeBoxTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBoxTheme {
                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
                Greeting()
//                }
            }
        }
    }
}

var name: MutableState<String> = mutableStateOf("同学")


var navController: NavHostController? = null;

@Composable
fun Greeting() {
    navController = rememberNavController()
    NavHost(
        navController = navController!!,
        startDestination = "MainScreen"
    ) {
        composable("MainScreen") {
            mainScreen()
        }
        composable("TextScreen") {
            TextScreen()
        }
        composable("TextFieldScreen") {
            TextFieldScreen()
        }
        composable("RowScreen") {
            RowScreen()
        }
        composable("ColumnScreen") {
            ColumnScreen()
        }
        composable("ButtonScreen") {
            ButtonScreen()
        }
        composable("CardScreen") {
            CardScreen()
        }
        composable("SwitchScreen") {
            SwitchScreen()
        }
        composable("DialogScreen") {
            DialogScreen()
        }
        composable("CanvasScreen") {
            CanvasScreen()
        }
        composable("ImageScreen") {
            ImageScreen()
        }



    }


}

@Composable
fun TopAppBarDemo() {
    TopAppBar(
        title = { Text("JetPackComposeBox") },
//        navigationIcon = {
//            IconButton(onClick = { }) {
//                Icon(Icons.Filled.ArrowBack, null)
//            }
//        },
        actions = {
//            IconButton(onClick = { }) {
//                Icon(Icons.Filled.Share, null)
//            }
//            IconButton(onClick = { }) {
//                Icon(Icons.Filled.Settings, null)
//            }
        }
    )
}

@Composable
fun BottomAppBarDemo() {
    BottomAppBar {
//        Text(text = "底部标题栏")

//        Spacer(Modifier.weight(1f, true))

        IconButton(modifier = Modifier.weight(1f,true),onClick = { }) {
            Icon(Icons.Filled.Favorite, null)
        }
//        Spacer(modifier = Modifier.weight(1f,true))
        IconButton(modifier = Modifier.weight(1f,true),
            onClick = { }) {
            Icon(Icons.Filled.Share, null)
        }
    }
}


@Composable
fun mainScreen() {
    Scaffold(topBar = {TopAppBarDemo()},bottomBar = { BottomAppBarDemo()}) {

            Column(
                modifier = Modifier
                    .background(color = Color(0xfff0f0f0))
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
            ) {

                Box(
                    Modifier
                        .clickable {
                            name.value = "风的影子"
                        }
                        .padding(8.dp)) {
                    Text(text = "你好! ${name.value},这是一个学习Jetpack Compose组件的APP,希望它可以给你带来帮助!")
                }
                mainListItem(text = "Text", info = "基础文本控件", onClick = {
                    navController!!.navigate("TextScreen")
                })
                mainListItem(text = "TextField", info = "编辑框控件", onClick = {
                    navController!!.navigate("TextFieldScreen")
                })
                mainListItem(text = "Row", info = "横向布局(可滚动)", onClick = {
                    navController!!.navigate("RowScreen")
                })
                mainListItem(text = "Column", info = "纵向布局(可滚动)", onClick = {
                    navController!!.navigate("ColumnScreen")
                })
                mainListItem(text = "Image", info = "图片控件", onClick = {
                    navController!!.navigate("ImageScreen")
                })
                mainListItem(text = "Button", info = "按钮控件", onClick = {
                    navController!!.navigate("ButtonScreen")
                })
                mainListItem(text = "Stack", info = "层布局", onClick = {

                })
                mainListItem(text = "Theme", info = "主题", onClick = {

                })
                mainListItem(text = "Card", info = "卡片布局", onClick = {
                    navController!!.navigate("CardScreen")
                })
                mainListItem(text = "Shade", info = "阴影", onClick = {

                })
                mainListItem(text = "Switch", info = "切换控件", onClick = {
                    navController!!.navigate("SwitchScreen")
                })
                mainListItem(text = "Dialog", info = "对话框", onClick = {
                    navController!!.navigate("DialogScreen")
                })
                mainListItem(text = "AppBar", info = "应用标题", onClick = {

                })
                mainListItem(text = "Canvas", info = "画布", onClick = {
                    navController!!.navigate("CanvasScreen")
                })
                mainListItem(text = "Icon", info = "图标", onClick = {
                    navController!!.navigate("IconScreen")
                })
                Box(modifier = Modifier.height(100.dp)) {
                    
                }


            }

    }



}

@Composable
fun mainListItem(text: String, info: String, onClick: () -> Unit) {
    Box(
        Modifier
            .padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 4.dp)
            .clickable(onClick = onClick)
    ) {

        Column(
            modifier = Modifier
                .background(color = Color.White)
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(text, fontSize = 18.sp)
            Text(info, fontSize = 14.sp)
        }

    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeBoxTheme {
        Greeting()
    }
}