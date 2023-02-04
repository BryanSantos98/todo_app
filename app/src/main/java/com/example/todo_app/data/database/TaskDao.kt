package com.example.todo_app.data.database

import androidx.room.Dao
import androidx.room.Insert
import com.example.todo_app.data.model.home.Task

@Dao
interface TaskDao {

    @Insert
    fun insertTask(task: Task)
}