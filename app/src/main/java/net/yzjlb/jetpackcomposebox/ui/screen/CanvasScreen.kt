package net.yzjlb.jetpackcomposebox.ui.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.dp

@Composable
fun CanvasScreen(){
    ViewScreen(view = {
        Canvas(
            modifier = Modifier.fillMaxWidth()
                .height(80.dp),
        ) {

            drawIntoCanvas { canvas ->
                //
                val paint = Paint()
                var paint_container = Paint()
                paint_container.color = Color(0xffeeeeee)
                paint_container.style = PaintingStyle.Fill

                var paint_edge = Paint()
                paint_edge.color = Color(0xffd0d0d0)
                paint_edge.style = PaintingStyle.Stroke

                var paint_img = Paint()
                paint_img.color = Color.White
                paint_img.style = PaintingStyle.Fill
                var cir = 12f //切角大小
                var tail = 0f //尾翼
                var padding = 8f
                paint.style = PaintingStyle.Fill
                paint.color = Color.LightGray
                paint.strokeWidth = 3f
                //变坐标轴
//                canvas.translate(1f, -1f)
                var path = Path()
                path.moveTo(padding,padding+cir)
                path.lineTo(padding+cir, padding)

                path.lineTo(size.height-cir-padding-padding,padding)
                path.lineTo(size.height-padding-padding, cir+padding)

                path.lineTo(size.height-padding-padding, size.height-cir-padding-padding)
                path.lineTo(size.height-cir-padding-padding, size.height-padding-padding)

                path.lineTo(cir+padding, size.height-padding-padding)
                path.lineTo(padding, size.height-cir-padding-padding)
                path.lineTo(padding, cir+padding)
                canvas.drawPath(path = path,paint = paint)
//                canvas.drawCircle(Offset(100f, 100f), 100f, paint)

                //绘制图标背景

                //绘制内容背景
                var rect = Rect(left = size.height-padding, top = 12f+padding, right = size.width - tail-padding, bottom = size.height-12f-padding-padding)
                canvas.drawRect(rect, paint_container)
                //绘制尾翼
//                var path_tail = Path()
//                path_tail.moveTo(size.width-tail-padding, padding)
//                path_tail.lineTo(size.width-cir-padding, padding)
//                path_tail.lineTo(size.width-padding, cir+padding)
//                path_tail.lineTo(size.width-padding, size.height-cir-padding)
//                path_tail.lineTo(size.width-cir-padding, size.height-padding)
//                path_tail.lineTo(size.width-tail-padding,size.height-padding)
//                path_tail.lineTo(size.width-tail-padding, padding)
//                canvas.drawPath(path_tail,paint)
                canvas.drawRect(cir+padding,cir+padding, size.height-padding-padding-cir,size.height-padding-padding-cir, paint_img)

            }

        }
    },title = "Canvas") {
        
    }
}