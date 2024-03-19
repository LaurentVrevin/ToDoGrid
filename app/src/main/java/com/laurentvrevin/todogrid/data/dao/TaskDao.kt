package com.laurentvrevin.todogrid.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.laurentvrevin.todogrid.data.entities.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getAllTasks(): Flow<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(taskEntity: TaskEntity)

    @Update
    suspend fun updateTask(taskEntity: TaskEntity)

    @Query("DELETE from tasks WHERE id = :id")
    suspend fun deleteTask(id: Int)

    @Query("DELETE from tasks ")
    suspend fun deleteAllTasks()

    //ORDER BY priority DESC
    @Query("SELECT * FROM tasks ORDER BY priority DESC")
    fun getTasksSortedByPriority(): Flow<List<TaskEntity>>

    //ORDER BY deadline ASC
    @Query("SELECT * FROM tasks ORDER BY deadline ASC")
    fun getTasksSortedByDeadline(): Flow<List<TaskEntity>>

    //ORDER BY status DESC
    @Query("SELECT * FROM tasks ORDER BY status DESC")
    fun getTasksSortedByStatus(): Flow<List<TaskEntity>>

    //ORDER BY status
    @Query("SELECT * FROM tasks WHERE status = :status")
    fun getTasksByStatus(status: String): Flow<List<TaskEntity>>

}