package com.choilabo.todo.data.todo

import com.choilabo.todo.data.todo.entity.Todo
import com.choilabo.todo.data.todo.repository.TodoRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

/**
 * Created by sato_shinichiro on 2020-01-10
 */
interface TodoModel {

    fun observe(): Flowable<List<Todo>>

    fun save(title: String): Completable

    fun delete(todo: Todo): Completable
}

class TodoModelImpl @Inject constructor(
    private val todoRepository: TodoRepository
) : TodoModel {

    override fun observe(): Flowable<List<Todo>> {
        return todoRepository.observe()
    }

    override fun save(title: String): Completable {
        return Completable.fromAction {
            todoRepository.save(
                Todo(
                    id = UUID.randomUUID().toString(),
                    title = title,
                    updatedAt = System.currentTimeMillis()
                )
            )
        }.subscribeOn(Schedulers.io())
    }

    override fun delete(todo: Todo): Completable {
        return Completable.fromAction {
            todoRepository.delete(todo)
        }.subscribeOn(Schedulers.io())
    }
}