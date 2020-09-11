package com.choilabo.todo.data.todo.repository

import com.choilabo.todo.data.db.TodoRoomDatabase
import com.choilabo.todo.data.todo.entity.Todo
import dagger.Reusable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by sato_shinichiro on 2020-01-10
 */
@Reusable
class TodoRepository @Inject constructor(
    private val database: TodoRoomDatabase
) {

    fun observe(): Flow<List<Todo>> {
        return database.todoDao().observe()
    }

    fun save(todo: Todo) {
        database.runInTransaction {
            database.todoDao().insert(todo)
        }
    }

    fun delete(todo: Todo) {
        database.runInTransaction {
            database.todoDao().delete(todo)
        }
    }
}