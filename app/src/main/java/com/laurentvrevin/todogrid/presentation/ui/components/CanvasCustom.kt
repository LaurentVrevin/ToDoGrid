package com.laurentvrevin.todogrid.presentation.ui.components


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
fun DrawScope.drawBackgroundAndDoodleBorder(
    backgroundColor: Color,
    borderColor: Color,
    strokeWidth: Dp,
    cornerRadius: Dp
) {
    val strokePx = strokeWidth.toPx()
    val pathEffect = PathEffect.cornerPathEffect(cornerRadius.toPx())

    // Dessine le fond
    drawRoundRect(
        color = backgroundColor,
        size = Size(size.width - strokePx, size.height - strokePx),
        cornerRadius = CornerRadius(cornerRadius.toPx())
    )

    // Dessine la bordure
    drawRoundRect(
        color = borderColor,
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
    borderColor: Color = Color.Black,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier) {

        Canvas(modifier = Modifier.matchParentSize()) {
            drawBackgroundAndDoodleBorder(
                backgroundColor = Color.White,
                borderColor = borderColor,
                strokeWidth = strokeWidth,
                cornerRadius = cornerRadius
            )
        }
        content()
    }
}