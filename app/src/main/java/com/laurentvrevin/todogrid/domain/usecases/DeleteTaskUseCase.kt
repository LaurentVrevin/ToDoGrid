package com.laurentvrevin.todogrid.domain.usecases

import com.laurentvrevin.todogrid.domain.repositories.TaskRepository
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(private val todoRepository: TaskRepository) {
    suspend operator fun invoke(id: Int) = todoRepository.deleteTask(id)
}