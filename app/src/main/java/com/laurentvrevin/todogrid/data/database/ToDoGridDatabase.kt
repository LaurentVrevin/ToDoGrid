package com.laurentvrevin.todogrid.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.laurentvrevin.todogrid.data.dao.TaskDao
import com.laurentvrevin.todogrid.data.entities.TaskEntity
import com.laurentvrevin.todogrid.data.converters.Converters

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ToDoGridDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}