package com.example.todo_app.data.model.home

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "status") val status: String,
    @ColumnInfo(name = "create_date") val createDate: Date = Date(),
    @ColumnInfo(name = "finish_date") val finishDate: String
)