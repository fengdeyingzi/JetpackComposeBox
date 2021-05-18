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
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

var name: MutableState<String> = mutableStateOf("Android")

@Composable
fun Greeting() {
    Column(modifier = Modifier.background(color = Color(0xfff0f0f0)).fillMaxWidth().fillMaxHeight().verticalScroll(rememberScrollState())) {
        Box(Modifier.clickable {
            name.value = "test"
        }) {
            Text(text = "Hello ${name.value}!")
        }
        mainListItem(text = "Text", info = "基础文本控件")
        mainListItem(text = "TextField", info = "编辑框控件")
        mainListItem(text = "Row", info = "横向布局(可滚动)")
        mainListItem(text = "Column", info = "纵向布局(可滚动)")
        mainListItem(text = "Image", info = "图片控件")
        mainListItem(text = "Button", info = "按钮控件")
        mainListItem(text = "Stack", info = "层布局")
        mainListItem(text = "Theme", info = "主题")
        mainListItem(text = "Card", info = "卡片布局")
        mainListItem(text = "Shade", info = "阴影")
        mainListItem(text = "Switch", info = "切换控件")
        mainListItem(text = "Dialog", info = "对话框")
        mainListItem(text = "AppBar", info = "应用标题")


    }

}

@Composable
fun mainListItem(text: String, info: String) {
    Box(Modifier.padding(top = 4.dp,start = 8.dp,end = 8.dp,bottom = 4.dp)) {

            Column(modifier = Modifier.background(color = Color.White).padding(8.dp).fillMaxWidth()) {
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