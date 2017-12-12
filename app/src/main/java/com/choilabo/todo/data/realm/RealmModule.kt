package com.choilabo.todo.data.realm

import dagger.Binds
import dagger.Module

/**
 * Created by sato_shinichiro on 2017/12/07.
 */
@Module
abstract class RealmModule {

    @Binds
    abstract fun provideRealmProvider(realmProvider: RealmProviderImpl): RealmProvider
}