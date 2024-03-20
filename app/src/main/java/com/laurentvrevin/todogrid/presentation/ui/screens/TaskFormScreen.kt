package com.laurentvrevin.todogrid.presentation.ui.screens

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
fun TaskFormScreen(
    taskViewModel: TaskViewModel,
    task: Task?=null,
    navController: NavController,
    taskId: Int?=null,
){
    val task = taskViewModel.tasks.value.find { it.id == taskId }

    var title by rememberSaveable { mutableStateOf(task?.title ?: "") }
    var description by rememberSaveable { mutableStateOf(task?.description ?: "") }
    var deadline by rememberSaveable { mutableStateOf(task?.deadline ?: Date()) }
    var priority by rememberSaveable { mutableStateOf(task?.priority ?: TaskPriority.MEDIUM)
    }

    Box (modifier = Modifier.fillMaxSize()) {
        Column (modifier = Modifier
            .fillMaxSize()

        ) {
            Text(text = "BenTasks", style = MaterialTheme.typography.displayLarge)
            TextField(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(16.dp),
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") }
            )
            TextField(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .heightIn(150.dp)
                    .fillMaxWidth()
                    .padding(16.dp),
                maxLines = 5,
                value = description,
                onValueChange = {description = it },
                label = { Text("Description") }
            )
            Button(
                onClick = {
                    if (task == null) {
                        // Ajoute une nouvelle tâche
                        taskViewModel.addTask(Task(
                            title = title,
                            description = description,
                            deadline = Date(),
                            createDate = Date(),
                            status = TaskStatus.TODO,
                            priority = priority))
                    } else {
                        // Mets à jour la tâche existante
                        taskViewModel.updateTask(task.copy(title = title, description = description /* autres champs */))
                    }
                    navController.navigate("taskList")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                ) {
                Text(text = if (task == null) "Ajouter" else "Mettre à jour")
            }
            }
        }
}

/*@Preview(showBackground = true)
@Composable
fun TaskFormScreenPreview(){
    TaskFormScreen(

    )
}*/