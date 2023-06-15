package net.yzjlb.jetpackcomposebox.ui.screen

import androidx.compose.runtime.Composable

@Composable
fun BottomAppBarScreen (){
    var names : MutableList<String> = mutableListOf("Android", "there")
    for( i in 0 until 100){
        names.add("item ${i}")
    }
    ViewScreen(view = {

    },title = "BottomAppBar") {

    }
}