package com.choilabo.todo.data

import android.app.Application
import android.content.Context
import com.choilabo.todo.App
import dagger.Binds
import dagger.Module

/**
 * Created by sato_shinichiro on 2020-01-10
 */
@Module
interface AppModule {

    @Binds
    abstract fun provideApplication(app: App): Application

    @Binds
    abstract fun provideApplicationContext(application: Application): Context
}