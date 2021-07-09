package net.yzjlb.jetpackcomposebox.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import net.yzjlb.jetpackcomposebox.R

@Composable
fun ImageScreen(){
    ViewScreen(view = {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
        )
    }) {

    }

}