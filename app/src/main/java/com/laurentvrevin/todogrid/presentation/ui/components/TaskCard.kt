package com.laurentvrevin.todogrid.presentation.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.laurentvrevin.todogrid.domain.models.Task
import com.laurentvrevin.todogrid.domain.models.TaskPriority
import com.laurentvrevin.todogrid.domain.models.TaskStatus
import java.util.Date

@SuppressLint("SimpleDateFormat")
@Composable
fun TaskCard(
    task: Task,
    onTaskClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clickable(onClick = onTaskClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = task.deadline.toString(),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Canvas(modifier = Modifier.matchParentSize()) {
                val strokeWidth = 2.dp.toPx()
                val pathEffect = PathEffect.cornerPathEffect(12.dp.toPx())
                drawRoundRect(
                    color = Color.Black,
                    size = Size(size.width - strokeWidth, size.height - strokeWidth), // Ajuste la taille pour le stroke
                    cornerRadius = CornerRadius(12.dp.toPx()),
                    style = Stroke(width = strokeWidth, pathEffect = pathEffect)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskCardPreview() {
    TaskCard(
        task = Task(
            id = 1,
            title = "Apprendre Jetpack Compose",
            description = "Découvrir comment utiliser Jetpack Compose pour construire des UIs modernes en Kotlin.",
            deadline = Date(),
            status = TaskStatus.TODO,
            priority = TaskPriority.HIGH
        ),
        onTaskClick = {}
    )
}