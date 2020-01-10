package com.choilabo.todo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.choilabo.todo.data.todo.dao.TodoDao
import com.choilabo.todo.data.todo.entity.Todo

/**
 * Created by sato_shinichiro on 2020-01-10
 */
@Database(
    version = 1,
    entities = arrayOf(
        Todo::class
    )
)
abstract class TodoRoomDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "todo_database"
    }

    abstract fun todoDao(): TodoDao
}