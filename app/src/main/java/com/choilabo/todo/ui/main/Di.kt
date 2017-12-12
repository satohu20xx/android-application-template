package com.choilabo.todo.ui.main

import android.app.Activity
import dagger.Binds
import dagger.Subcomponent
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap


/**
 * Created by sato_shinichiro on 2017/12/07.
 */
@dagger.Module(subcomponents = arrayOf(Component::class))
abstract class MainActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun bind(builder: Component.Builder): AndroidInjector.Factory<out Activity>
}

@Subcomponent
interface Component : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}
