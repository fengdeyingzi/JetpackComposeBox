package net.yzjlb.jetpackcomposebox.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import net.yzjlb.jetpackcomposebox.Greeting
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text

@Composable
fun ListScreen (){
    var names : MutableList<String> = mutableListOf("Android", "there")
    for( i in 0 until 100){
        names.add("item ${i}")
    }
    ViewScreen(view = {
        LazyColumn() {
            items(items = names) { name ->
                Text(name,modifier = Modifier.fillMaxWidth().height(32.dp))
                Divider(color = Color.Black)
            }
        }
    },title = "LazyColumn") {

    }
}