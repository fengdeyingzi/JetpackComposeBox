package net.yzjlb.jetpackcomposebox.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColumnScreen (){
    ViewScreen(view = {
        Column() {
            Box(modifier = Modifier.width(32.dp).height(32.dp).background(color = Color.Yellow)) {

            }
            Box(modifier = Modifier.width(32.dp).height(32.dp).background(color = Color.Red)) {

            }
            Box(modifier = Modifier.width(32.dp).height(32.dp).background(color = Color.Green)) {

            }
        }
    },title = "Column") {

    }
}