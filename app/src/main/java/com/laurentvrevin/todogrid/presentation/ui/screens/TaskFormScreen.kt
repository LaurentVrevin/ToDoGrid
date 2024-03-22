package com.laurentvrevin.todogrid.presentation.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.laurentvrevin.todogrid.domain.models.TaskPriority
import com.laurentvrevin.todogrid.presentation.ui.components.CustomTextField
import com.laurentvrevin.todogrid.presentation.ui.components.DatePickerButton
import com.laurentvrevin.todogrid.presentation.ui.components.DoodleBorderBox
import com.laurentvrevin.todogrid.presentation.ui.components.PrioritySelector
import com.laurentvrevin.todogrid.presentation.ui.components.SubmitButton
import com.laurentvrevin.todogrid.presentation.viewmodels.TaskViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


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
    val dateFormatter = remember { SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()) }

    // Etat pour la date avec un format de date lisible
    var selectedDate by rememberSaveable { mutableStateOf(dateFormatter.format(task?.deadline ?: Date())) }

    // Les `rememberSaveable` permettent de conserver les états lors des recompositions
    var title by rememberSaveable { mutableStateOf(task?.title ?: "") }
    var description by rememberSaveable { mutableStateOf(task?.description ?: "") }
    var deadline by rememberSaveable { mutableStateOf(task?.deadline ?: Date()) }
    var priority by rememberSaveable { mutableStateOf(task?.priority ?: TaskPriority.MEDIUM) }

    Box (modifier = Modifier.fillMaxSize())
    {
        Column (modifier = Modifier
            .fillMaxSize()

        ) {
            Text(text = "BenTasks", style = MaterialTheme.typography.displayLarge)

            //UI pour le titre et la description
            Box(modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier.fillMaxSize()) {

                    //Ui pour les TextFields de titre et description
                    CustomTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("Title") },
                        maxLines = 1

                    )

                    CustomTextField(
                        value = description,
                        onValueChange = { description = it },
                        label = { Text("Description") },
                        maxLines = 5,
                        height = 250.dp
                    )

                    // UI pour le DatePicker
                    DatePickerButton(selectedDate = selectedDate) { newSelectedDate ->
                        selectedDate = newSelectedDate
                        // Parse la nouvelle date sélectionnée et met à jour l'état deadline
                        deadline = dateFormatter.parse(newSelectedDate) ?: deadline
                    }

                    //UI pour la sélection de la priorité
                    PrioritySelector(priority = priority) { newPriority ->
                        priority = newPriority
                    }

                    //UI pour le bouton submit
                    SubmitButton(
                        isUpdating = task != null,
                        onSubmit = {
                            taskViewModel.submitTask(
                                task = task,
                                title = title,
                                description = description,
                                deadline = deadline,
                                priority = priority
                            )
                            navController.navigate("taskList")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}
