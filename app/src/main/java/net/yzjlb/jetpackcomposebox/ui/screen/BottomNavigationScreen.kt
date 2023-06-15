package net.yzjlb.jetpackcomposebox.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigationScreen (){
    var names : MutableList<String> = mutableListOf("Android", "there")
    for( i in 0 until 100){
        names.add("item ${i}")
    }
    ViewScreen(view = {
        LazyColumn() {

        }
    },title = "LazyColumn") {

    }
}