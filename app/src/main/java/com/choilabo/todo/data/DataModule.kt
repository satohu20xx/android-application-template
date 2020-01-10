package com.choilabo.todo.data

import com.choilabo.todo.data.db.DatabaseModule
import com.choilabo.todo.data.todo.TodoModule
import dagger.Module

/**
 * Created by sato_shinichiro on 2020-01-10
 */
@Module(
    includes = [
        DatabaseModule::class,
        TodoModule::class
    ]
)
interface DataModule