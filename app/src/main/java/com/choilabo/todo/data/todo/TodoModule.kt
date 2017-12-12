package com.choilabo.todo.data.todo

import com.choilabo.todo.data.todo.local.TodoDataClient
import com.choilabo.todo.data.todo.local.TodoRealmClient
import dagger.Binds
import dagger.Module

/**
 * Created by sato_shinichiro on 2017/12/04.
 */
@Module
abstract class TodoModule {

    @Binds
    abstract fun provideTodoDataClient(todoRealmClient: TodoRealmClient): TodoDataClient
}