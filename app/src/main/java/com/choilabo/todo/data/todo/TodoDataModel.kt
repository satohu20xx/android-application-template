package com.choilabo.todo.data.todo

import com.choilabo.todo.data.todo.entity.Todo
import com.choilabo.todo.data.todo.repository.TodoRepository
import dagger.Reusable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

/**
 * Created by sato_shinichiro on 2020-01-10
 */
@Reusable
class TodoDataModel @Inject constructor(
    private val todoRepository: TodoRepository
) {

    fun observe(): Flow<List<Todo>> {
        return todoRepository.observe()
    }

    suspend fun save(title: String) {
        withContext(Dispatchers.IO) {
            todoRepository.save(
                Todo(
                    id = UUID.randomUUID().toString(),
                    title = title,
                    updatedAt = System.currentTimeMillis()
                )
            )
        }
    }

    suspend fun delete(todo: Todo) {
        withContext(Dispatchers.IO) {
            todoRepository.delete(todo)
        }
    }
}