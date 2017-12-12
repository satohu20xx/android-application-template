package com.choilabo.todo

import com.choilabo.todo.data.realm.RealmProvider
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by sato_shinichiro on 2017/12/04.
 */
class App : DaggerApplication() {

    @Inject
    lateinit var realmProvider: RealmProvider

    override fun onCreate() {
        super.onCreate()



        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<App> {
        return DaggerAppComponent.builder()
                .create(this)
    }
}