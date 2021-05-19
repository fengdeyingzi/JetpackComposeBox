package net.yzjlb.jetpackcomposebox.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.navigate
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
//                    IconButton(onClick = { }) {
//                        Icon(Icons.Filled.Share, null)
//                    }
//                    IconButton(onClick = { }) {
//                        Icon(Icons.Filled.Settings, null)
//                    }
                }
            )
        }) {
            Column(modifier = Modifier.height(120.dp),content = view)
            Column(modifier = Modifier.padding(start = 8.dp,top = 128.dp,end = 8.dp,bottom = 8.dp).fillMaxHeight(),content = content)
        }


}