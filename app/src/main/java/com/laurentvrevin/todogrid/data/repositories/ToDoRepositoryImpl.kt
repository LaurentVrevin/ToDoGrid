package com.laurentvrevin.todogrid.data.repositories

import com.laurentvrevin.todogrid.data.dao.TaskDao
import com.laurentvrevin.todogrid.domain.repositories.ToDoRepository
import javax.inject.Inject

class ToDoRepositoryImpl @Inject constructor(private val taskDao: TaskDao): ToDoRepository {
}