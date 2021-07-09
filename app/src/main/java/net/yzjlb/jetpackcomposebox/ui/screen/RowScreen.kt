package net.yzjlb.jetpackcomposebox.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RowScreen (){
    ViewScreen(view = {
        Row() {
            Box(modifier = Modifier.width(32.dp).height(32.dp).background(color = Color.Yellow)) {

            }
            Box(modifier = Modifier.width(32.dp).height(32.dp).background(color = Color.Red)) {

            }
            Box(modifier = Modifier.width(32.dp).height(32.dp).background(color = Color.Green)) {

            }
        }
    },title = "Row") {

    }
}