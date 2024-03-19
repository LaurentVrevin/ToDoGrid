package com.laurentvrevin.todogrid.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laurentvrevin.todogrid.domain.models.Task
import com.laurentvrevin.todogrid.domain.repositories.TaskRepository
import com.laurentvrevin.todogrid.domain.usecases.AddTaskUseCase
import com.laurentvrevin.todogrid.domain.usecases.DeleteTaskUseCase
import com.laurentvrevin.todogrid.domain.usecases.GetAllTasksUseCase
import com.laurentvrevin.todogrid.domain.usecases.UpdateTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val getAllTasksUseCase: GetAllTasksUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase
    ) : ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    init {
        loadTasks()
    }

    private fun loadTasks() {
        viewModelScope.launch {
            getAllTasksUseCase().collect { listOfTasks ->
                _tasks.value = listOfTasks
            }
        }
    }

    fun addTask(task: Task) {
        viewModelScope.launch {
            addTaskUseCase(task)
            loadTasks()
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            updateTaskUseCase(task)
            loadTasks()
        }
    }

    fun deleteTask(id: Int) {
        viewModelScope.launch {
            deleteTaskUseCase(id)
            loadTasks()
        }
    }

}