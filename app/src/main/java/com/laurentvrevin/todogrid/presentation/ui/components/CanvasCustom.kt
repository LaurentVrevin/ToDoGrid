package com.laurentvrevin.todogrid.presentation.ui.components


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Fonction réutilisable pour dessiner une bordure personnalisée.
fun DrawScope.drawDoodleBorder(
    color: Color,
    strokeWidth: Dp,
    cornerRadius: Dp
) {
    val strokePx = strokeWidth.toPx()
    val pathEffect = PathEffect.cornerPathEffect(cornerRadius.toPx())
    drawRoundRect(
        color = color,
        size = Size(size.width - strokePx, size.height - strokePx),
        cornerRadius = CornerRadius(cornerRadius.toPx()),
        style = Stroke(width = strokePx, pathEffect = pathEffect)
    )
}

@Composable
fun DoodleBorderBox(
    modifier: Modifier = Modifier,
    strokeWidth: Dp = 2.dp,
    cornerRadius: Dp = 12.dp,
    color: Color = Color.Black,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier) {
        content()
        Canvas(modifier = Modifier.matchParentSize()) {
            drawDoodleBorder(
                color = color,
                strokeWidth = strokeWidth,
                cornerRadius = cornerRadius
            )
        }
    }
}