package net.yzjlb.jetpackcomposebox.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import net.yzjlb.jetpackcomposebox.R
import net.yzjlb.jetpackcomposebox.TopAppBarDemo
import net.yzjlb.jetpackcomposebox.navController

/*
用来做演示的控件
 */
@Composable
fun ViewScreen(view: @Composable ColumnScope.() -> Unit,title:String = "JetpackComposeBox", content: @Composable ColumnScope.() -> Unit) {

        Scaffold(topBar = {
            TopAppBar(
                title = { Text(title) },
                navigationIcon = {
                    IconButton(onClick = {
                        navController!!.popBackStack()
                    }) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(painter = painterResource(id = R.drawable.code),
                            contentDescription = null)
                    }
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.Info, null)
                    }
                }
            )
        }) {
            Column(modifier = Modifier.height(240.dp),content = view)
            Column(modifier = Modifier
                .padding(start = 8.dp, top = 128.dp, end = 8.dp, bottom = 8.dp)
                .fillMaxHeight(),content = content)
        }


}

//颜色列表
fun ColorsView(color:MutableState<Color>){

}

fun BgColorsView(color:MutableState<Color>){

}

//显示代码
@Composable
fun CodeView(codetext:String,isshow:MutableState<Boolean>){
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)) {

        }
        Text(codetext, modifier = Modifier.fillMaxWidth())
    }

}

//切换
@Composable
fun SwitchView(text:String,ischeck: MutableState<Boolean>){
    Row(modifier = Modifier.fillMaxWidth()){
        Text(text,modifier = Modifier.weight(1f))
        Switch(checked = ischeck.value,onCheckedChange = {
            ischeck.value = it
        })
    }
}

//按钮
@Composable
fun ButtonX(text:String,onClick: () -> Unit){
    Button(onClick = onClick) {
        Text(text)
    }
}