package com.choilabo.todo.data

import com.choilabo.todo.data.todo.TodoModule
import dagger.Module

/**
 * Created by sato_shinichiro on 2017/12/04.
 */
@Module(includes = arrayOf(
        TodoModule::class
))
class DataModule