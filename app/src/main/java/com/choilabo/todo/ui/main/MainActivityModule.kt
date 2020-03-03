package com.choilabo.todo.ui.main

import com.choilabo.todo.di.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by sato_shinichiro on 2020/03/03
 */
@Module
interface MainActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainActivity.Module::class))
    fun contributeMainActivityInjector(): MainActivity
}