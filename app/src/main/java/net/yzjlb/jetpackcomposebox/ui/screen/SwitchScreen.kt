package net.yzjlb.jetpackcomposebox.ui.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun SwitchScreen(){
    var checked: MutableState<Boolean> = remember { mutableStateOf(false) }
    ViewScreen(view = {
        Switch(checked = checked.value,onCheckedChange = {
            checked.value = it
        })
    },title = "Switch") {
        Row() {
            Text("是否启用")
            Switch(checked = checked.value,onCheckedChange = {
                checked.value = it
            })
        }
    }
}