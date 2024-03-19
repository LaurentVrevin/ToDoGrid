package com.laurentvrevin.todogrid.di

import com.laurentvrevin.todogrid.data.dao.TaskDao
import com.laurentvrevin.todogrid.data.repositories.ToDoRepositoryImpl
import com.laurentvrevin.todogrid.domain.repositories.ToDoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTodoRepository(taskDao: TaskDao): ToDoRepository  = ToDoRepositoryImpl(taskDao)

}