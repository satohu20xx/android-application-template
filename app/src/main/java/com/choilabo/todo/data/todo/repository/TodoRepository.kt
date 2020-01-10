package com.choilabo.todo.data.todo.repository

import com.choilabo.todo.data.db.TodoRoomDatabase
import com.choilabo.todo.data.todo.entity.Todo
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by sato_shinichiro on 2020-01-10
 */
interface TodoRepository {

    fun observe(): Flowable<List<Todo>>

    fun save(todo: Todo)

    fun delete(todo: Todo)
}

class TodoRoomClient @Inject constructor(
    private val database: TodoRoomDatabase
) : TodoRepository {

    override fun observe(): Flowable<List<Todo>> {
        return database.todoDao().observe()
    }

    override fun save(todo: Todo) {
        database.runInTransaction {
            database.todoDao().insert(todo)
        }
    }

    override fun delete(todo: Todo) {
        database.runInTransaction {
            database.todoDao().delete(todo)
        }
    }
}