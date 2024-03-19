package com.laurentvrevin.todogrid.di

import androidx.room.TypeConverters
import com.laurentvrevin.todogrid.data.dao.TaskDao
import com.laurentvrevin.todogrid.data.repositories.ToDoRepositoryImpl
import com.laurentvrevin.todogrid.domain.repositories.ToDoRepository
import com.laurentvrevin.todogrid.utils.Converters
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