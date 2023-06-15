package net.yzjlb.jetpackcomposebox

import android.os.Bundle
import android.webkit.WebView
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
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.yzjlb.jetpackcomposebox.ui.screen.*
import net.yzjlb.jetpackcomposebox.ui.theme.JetpackComposeBoxTheme
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {

    @ExperimentalMaterialApi
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

@ExperimentalMaterialApi
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
        composable("WebViewScreen"){
            WebViewScreen()
        }
        composable("BottomDrawerScreen"){
            ButtomDrawerScreen()
        }
        composable("ListScreen"){
            ListScreen()
        }
        composable("Box"){
            BoxScreen()
        }
        composable("TopAppBar"){
            TopAppBarScreen()
        }
        composable("BottomNavigation"){
            BottomNavigationScreen()
        }
        composable("BottomAppBar"){
            BottomAppBarScreen()
        }
        composable("TabBarScreen"){
            TabBarScreen()
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
    val items = mutableListOf<String>()
    var selectedItem: MutableState<Int> = remember {mutableStateOf(0)}
    items.add("控件")
    items.add("资料")
    items.add("博客")
    BottomNavigation {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Info, contentDescription = null) },
                label = { Text(item) },
                selected = selectedItem.value == index,
                onClick = { selectedItem.value = index }
            )
        }
    }
//    BottomAppBar {
////        Text(text = "底部标题栏")
//
////        Spacer(Modifier.weight(1f, true))
//
//        IconButton(modifier = Modifier.weight(1f,true),onClick = { }) {
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                Icon(Icons.Filled.Favorite, null)
//                Text("控件")
//            }
//
//        }
////        Spacer(modifier = Modifier.weight(1f,true))
//        IconButton(modifier = Modifier.weight(1f,true),
//            onClick = { }) {
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                Icon(Icons.Filled.Share, null)
//                Text("资料")
//            }
//
//        }
//    }
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
                TabRow(selectedTabIndex = 0) {
                    Tab(selected = true, onClick = {

                    }) {
Column(verticalArrangement = Arrangement.Center,modifier = Modifier.height(40.dp)) {
    Text("测试",textAlign = TextAlign.Center,)
}

                    }
                    Tab(selected = true, onClick = {

                    }) {
                        Column(verticalArrangement = Arrangement.Center,modifier = Modifier.height(40.dp)) {
                            Text("测试2",textAlign = TextAlign.Center)
                        }

                    }
                }
                Box(
                    Modifier
                        .clickable {
                            name.value = "风的影子"
                        }
                        .padding(8.dp)) {
                    Text(text = "你好! ${name.value},这是一个学习Jetpack Compose组件的APP,希望它可以给你带来帮助!\nhttps://github.com/fengdeyingzi/JetpackComposeBox")
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
                mainListItem(text = "WebView", info = "内嵌安卓原生WebView") {
                    navController!!.navigate("WebViewScreen")
                }
                mainListItem(text = "BottomDrawer", info = "底部抽屉") {
                    navController!!.navigate("BottomDrawerScreen")
                }
                mainListItem(text = "List", info = "只显示可显示区域的选项列表") {
                    navController!!.navigate("ListScreen")
                }
                mainListItem(text = "TabBar", info = "可滑动和点击的标签栏，通常用于AppBar的底部") {
                    navController!!.navigate("TabBarScreen")
                }
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

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeBoxTheme {
        Greeting()
    }
}