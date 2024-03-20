package com.laurentvrevin.todogrid.presentation.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.laurentvrevin.todogrid.domain.models.Task
import com.laurentvrevin.todogrid.presentation.viewmodels.TaskViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun TaskDetailScreen(
    taskViewModel: TaskViewModel,
    taskId: Int,
    navController: NavController,
    onEditTask: (Task) -> Unit,
    onDeleteTask: (Task) -> Unit
) {

    val task = taskViewModel.tasks.value.find { it.id == taskId }

    Column {
        if (task != null) {
            Text(text = task.title)
            Text(text = task.description)
        }

        Button(onClick = { task?.let(onEditTask) }) {
            Text("Modifier")
        }
        Button(onClick = { task?.let(onDeleteTask) }) {
            Text("Supprimer")
        }
    }
}