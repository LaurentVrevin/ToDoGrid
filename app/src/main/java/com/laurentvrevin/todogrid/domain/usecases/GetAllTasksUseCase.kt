package com.laurentvrevin.todogrid.domain.usecases

import com.laurentvrevin.todogrid.domain.models.Task
import com.laurentvrevin.todogrid.domain.repositories.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTasksUseCase@Inject constructor(private val todoRepository: TaskRepository) {
    operator fun invoke(): Flow<List<Task>> = todoRepository.getAllTasks()
}