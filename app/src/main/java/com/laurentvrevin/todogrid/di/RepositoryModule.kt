package com.laurentvrevin.todogrid.di

import com.laurentvrevin.todogrid.data.dao.TaskDao
import com.laurentvrevin.todogrid.data.repositories.TaskRepositoryImpl
import com.laurentvrevin.todogrid.domain.repositories.TaskRepository
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
    fun provideTodoRepository(taskDao: TaskDao): TaskRepository  = TaskRepositoryImpl(taskDao)

}