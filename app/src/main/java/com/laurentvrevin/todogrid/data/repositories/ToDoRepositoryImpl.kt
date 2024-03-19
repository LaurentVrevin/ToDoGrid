package com.laurentvrevin.todogrid.data.repositories

import com.laurentvrevin.todogrid.data.dao.TaskDao
import com.laurentvrevin.todogrid.domain.mapper.toDomainModel
import com.laurentvrevin.todogrid.domain.mapper.toEntity
import com.laurentvrevin.todogrid.domain.models.Task
import com.laurentvrevin.todogrid.domain.repositories.ToDoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

abstract class ToDoRepositoryImpl @Inject constructor(private val taskDao: TaskDao): ToDoRepository {

    override fun getAllTasks(): Flow<List<Task>> =
        taskDao.getAllTasks().map { entities ->
            entities.map { it.toDomainModel() }
        }

    override suspend fun insertTask(task: Task) {
        taskDao.insertTask(task.toEntity())
    }

    override suspend fun updateTask(task: Task) {
        taskDao.updateTask(task.toEntity())
    }

    override suspend fun deleteTask(id: Int) {
        taskDao.deleteTask(id)
    }


}