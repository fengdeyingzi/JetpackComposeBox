package net.yzjlb.jetpackcomposebox.ui.screen

import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.webkit.WebView
import android.widget.LinearLayout
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebViewScreen(){
    var checked: MutableState<Boolean> = remember { mutableStateOf(false) }
    ViewScreen(view = {
        Switch(checked = checked.value,onCheckedChange = {
            checked.value = it
        })
    },title = "WebView") {



            //widget.Button
            AndroidView(
                factory = { ctx ->
                    //Here you can construct your View
                    WebView(ctx).apply {
                        loadUrl("https://github.com/fengdeyingzi/JetpackComposeBox")
                        layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
                    }
                },
                modifier = Modifier.padding(8.dp)
            )



    }
}