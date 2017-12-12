package com.choilabo.todo.ui

import com.choilabo.todo.data.DataModule
import com.choilabo.todo.ui.delegate.LifecycleDisposableDelegate
import com.choilabo.todo.ui.delegate.impl.LifecycleDisposableDelegateImpl
import com.choilabo.todo.ui.main.MainActivityModule
import com.choilabo.todo.ui.todo.create.TodoCreateActivityModule
import com.choilabo.todo.ui.todo.detail.TodoDetailActivityModule
import dagger.Binds
import dagger.Module

/**
 * Created by sato_shinichiro on 2017/12/04.
 */
@Module(includes = arrayOf(
        DataModule::class,
        MainActivityModule::class,
        TodoCreateActivityModule::class,
        TodoDetailActivityModule::class
))
abstract class ActivityModule {
    @Binds
    abstract fun provideLifecycleDisposableDelegate(lifecycleDisposableDelegate: LifecycleDisposableDelegateImpl): LifecycleDisposableDelegate
}