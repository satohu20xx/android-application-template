package com.choilabo.todo.ui

import androidx.lifecycle.ViewModelProvider
import com.choilabo.todo.di.ViewModelFactory
import com.choilabo.todo.ui.main.MainActivityModule
import dagger.Binds
import dagger.Module

/**
 * Created by sato_shinichiro on 2020-01-10
 */
@Module(
    includes = [
        MainActivityModule::class
    ]
)
interface ActivityModule {

    @Binds
    fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}