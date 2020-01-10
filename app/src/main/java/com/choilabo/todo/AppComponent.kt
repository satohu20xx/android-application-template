package com.choilabo.todo

import com.choilabo.todo.data.AppModule
import com.choilabo.todo.data.DataModule
import com.choilabo.todo.ui.ActivityModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by sato_shinichiro on 2020-01-10
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        DataModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<App>
}