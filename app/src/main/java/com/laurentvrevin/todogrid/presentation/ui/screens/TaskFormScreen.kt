package com.laurentvrevin.todogrid.presentation.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.laurentvrevin.todogrid.domain.models.Task
import com.laurentvrevin.todogrid.domain.models.TaskPriority
import com.laurentvrevin.todogrid.domain.models.TaskStatus
import com.laurentvrevin.todogrid.presentation.ui.components.DoodleBorderBox
import com.laurentvrevin.todogrid.presentation.viewmodels.TaskViewModel
import java.util.Date

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun TaskFormScreen(
    taskViewModel: TaskViewModel,
    navController: NavController,
    taskId: Int?=null,
){
    // Si taskId` n'est pas null, cherche la tâche correspondante
    val task = taskId?.let { id ->
        taskViewModel.tasks.value.find { it.id == id }
    }

    // Les `rememberSaveable` permettent de conserver les états lors des recompositions
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

            Box(modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier.fillMaxSize()) {

                    DoodleBorderBox(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(16.dp),
                        strokeWidth = 2.dp,
                        cornerRadius = 12.dp,
                        color = Color.Black
                    ) {
                        TextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            maxLines = 1,
                            value = title,
                            onValueChange = { title = it },
                            label = { Text("Title") },
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor =  Color.Transparent
                            )
                        )
                    }

                    DoodleBorderBox(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .heightIn(min = 150.dp)
                            .fillMaxWidth()
                            .padding(16.dp),
                        strokeWidth = 2.dp,
                        cornerRadius = 12.dp,
                        color = Color.Black
                    ) {
                        TextField(modifier = Modifier
                            .fillMaxWidth(),
                            maxLines = 5,
                            value = description,
                            onValueChange = { description = it },
                            label = { Text("Description") },
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor =  Color.Transparent

                            )
                        )
                    }


                    Button(
                        onClick = {
                            if (task == null) {
                                // Ajoute une nouvelle tâche
                                taskViewModel.addTask(
                                    Task(
                                        title = title,
                                        description = description,
                                        deadline = Date(),
                                        createDate = Date(),
                                        status = TaskStatus.TODO,
                                        priority = priority
                                    )
                                )
                            } else {
                                // Mets à jour la tâche existante
                                taskViewModel.updateTask(
                                    task.copy(
                                        title = title,
                                        description = description,
                                        deadline = deadline,
                                        createDate = Date(),
                                        status = TaskStatus.TODO,
                                        priority = priority
                                    )
                                )
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
    }
}
