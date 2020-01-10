package com.choilabo.todo.data.todo

import com.choilabo.todo.data.todo.repository.TodoRepository
import com.choilabo.todo.data.todo.repository.TodoRoomClient
import dagger.Binds
import dagger.Module

/**
 * Created by sato_shinichiro on 2020-01-10
 */
@Module
interface TodoModule {

    @Binds
    fun bindsTodoRepository(client: TodoRoomClient): TodoRepository

    @Binds
    fun bindsTodoModel(impl: TodoModelImpl): TodoModel
}