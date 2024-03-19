package com.laurentvrevin.todogrid.di

import android.content.Context
import androidx.room.Room
import androidx.room.TypeConverters
import com.laurentvrevin.todogrid.data.dao.TaskDao
import com.laurentvrevin.todogrid.data.database.ToDoGridDatabase
import com.laurentvrevin.todogrid.utils.Converters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): ToDoGridDatabase {
        return Room.databaseBuilder(appContext, ToDoGridDatabase::class.java, "todo_database").build()
    }

    @Provides
    fun provideTaskDao(database: ToDoGridDatabase): TaskDao = database.taskDao()
}