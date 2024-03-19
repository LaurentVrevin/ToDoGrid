package com.laurentvrevin.todogrid.domain.usecases

import com.laurentvrevin.todogrid.data.repositories.TaskRepositoryImpl
import com.laurentvrevin.todogrid.domain.models.Task
import javax.inject.Inject

class AddTaskUseCase @Inject constructor(private val repository: TaskRepositoryImpl) {
    suspend operator fun invoke(task: Task) {
        repository.insertTask(task)
    }
}