package com.choilabo.todo

import com.choilabo.todo.data.realm.RealmModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by sato_shinichiro on 2017/12/05.
 */
@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        RealmModule::class,
        AppModule::class
))
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}