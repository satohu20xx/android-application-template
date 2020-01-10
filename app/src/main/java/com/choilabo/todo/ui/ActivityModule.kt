package com.choilabo.todo.ui

import androidx.lifecycle.ViewModelProvider
import com.choilabo.todo.di.ActivityScope
import com.choilabo.todo.di.ViewModelFactory
import com.choilabo.todo.ui.main.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by sato_shinichiro on 2020-01-10
 */
@Module
interface ActivityModule {

    @Binds
    fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainActivity.Module::class))
    fun contributeMainActivityInjector(): MainActivity
}