package com.example.todo_app.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todo_app.data.model.home.Task
import com.example.todo_app.util.DateConverter

/***
 * para salvar no banco:
 *
 * val app = application as App
 * val dao = app.db.taskDao()
 * dao.insert(Task())
 *
 * sempre acessar o banco de dados de maneira assincrona
 * Thread {
 *
 * }.start()
 *
 */

@Database(entities = [Task::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "taskapp_database"
                    ).build()
                }
                INSTANCE as AppDatabase
            } else {
                INSTANCE as AppDatabase
            }
        }
    }
}