package net.yzjlb.jetpackcomposebox.ui.screen

import android.graphics.drawable.shapes.RectShape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun DialogScreen() {
    val openDialog = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val (gesturesEnabled, toggleGesturesEnabled) = remember { mutableStateOf(true) }
    ViewScreen(view = {

    }) {
        Column() {
            Switch(gesturesEnabled,null)
            Button(onClick = {
                openDialog.value = true
            }) {
                Text(text = "点击弹出对话框")
            }
            SelectionContainer() {
                Text("This is Select Text")
            }
            Box(modifier = Modifier
                .width(89.dp)
                .height(89.dp)
                .shadow(elevation = 3.dp, shape = RectangleShape)
                .background(color = Color.Blue, shape = CircleShape)) {


            }
            if (openDialog.value) {

                AlertDialog(
                    onDismissRequest = {
                        // Dismiss the dialog when the user clicks outside the dialog or on the back
                        // button. If you want to disable that functionality, simply use an empty
                        // onCloseRequest.
                        openDialog.value = false
                    },
                    title = {
                        Text(text = "Dialog Title")
                    },
                    text = {
                        Text("Here is a text ")
                    },
                    confirmButton = {
                        Button(

                            onClick = {
                                openDialog.value = false
                            }) {
                            Text("确定")
                        }
                    },
                    dismissButton = {
                        Button(

                            onClick = {
                                openDialog.value = false
                            }) {
                            Text("取消")
                        }
                    }
                )
            }

        }
    }
}