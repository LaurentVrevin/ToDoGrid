package com.laurentvrevin.todogrid.presentation.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.laurentvrevin.todogrid.domain.models.Task
import com.laurentvrevin.todogrid.domain.models.TaskPriority
import com.laurentvrevin.todogrid.domain.models.TaskStatus
import com.laurentvrevin.todogrid.presentation.viewmodels.TaskViewModel
import java.util.Date

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
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "BenTasks",
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .padding(16.dp)
        )

        Box(modifier = Modifier.padding(16.dp)) {

            Column {
                if (task != null) {
                    Text(
                        text = task.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                            .padding(16.dp),
                        style = MaterialTheme.typography.displayMedium
                    )
                    Text(
                        text = task.description,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                            .padding(16.dp),
                        style = MaterialTheme.typography.titleLarge
                    )
                }

                Button(
                    onClick = {
                        task?.let(onEditTask)
                        navController.navigate("taskForm/$taskId")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp),
                ) {
                    Text("Modifier")
                }

                Button(
                    onClick = {
                        task?.let(onDeleteTask)
                        taskViewModel.deleteTask(taskId)
                        navController.popBackStack()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp),
                ) {
                    Text("Supprimer")
                }
            }
        }
    }


}
