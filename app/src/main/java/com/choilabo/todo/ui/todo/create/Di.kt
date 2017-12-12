package com.choilabo.todo.ui.todo.create

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
abstract class TodoCreateActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(TodoCreateActivity::class)
    abstract fun bind(builder: Component.Builder): AndroidInjector.Factory<out Activity>
}

@Subcomponent
interface Component : AndroidInjector<TodoCreateActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<TodoCreateActivity>()
}
