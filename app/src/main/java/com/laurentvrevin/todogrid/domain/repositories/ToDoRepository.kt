package com.laurentvrevin.todogrid.domain.repositories

import com.laurentvrevin.todogrid.domain.models.Task
import kotlinx.coroutines.flow.Flow

interface ToDoRepository {
    fun getAllTasks(): Flow<List<Task>>
    suspend fun insertTask(task: Task)
    suspend fun updateTask(task: Task)
    suspend fun deleteTask(id: Int)
}